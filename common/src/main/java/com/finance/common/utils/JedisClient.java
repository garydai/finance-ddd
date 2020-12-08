package com.finance.common.utils;

import com.finance.common.api.ResultCode;
import com.finance.common.error.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.params.SetParams;

import java.util.Collections;

/**
 * @author daitechang
 * @create: 2020-09-17
 **/
@Slf4j
public class JedisClient {
    /**
     * 进件号前缀
     */
    public static String REDIS_APPLYMENT_PREFIX = "nds_applyment_";
    /**
     * 进件分布式锁前缀
     */
    public static String REDIS_APPLYMENT_LOCK_PREFIX = "nds_applyment_lock_";

    private static final String SUCCESS = "OK";
    private static final Long RELEASE_SUCCESS = 1L;

    @Autowired
    private JedisPool jedisPool;

    /**
     * 获取流水序号，每天从0开始统计，key要加上业务编号防止冲突
     *
     * @param dateKey
     * @return
     * @throws ServiceException
     */
    public long incr(String dateKey) throws ServiceException {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.incr(dateKey);
        } catch (Exception e) {
            log.error("incr fail", e);
            throw new ServiceException(ResultCode.REDIS_ERROR);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 获取锁
     *
     * @param key
     * @param requestId
     * @param expireTime
     * @throws Exception
     */
    public boolean lock(String key, String requestId, long expireTime) throws Exception {
        try (Jedis jedis = jedisPool.getResource()) {
            SetParams params = new SetParams();
            params.px(expireTime);
            params.nx();
            return SUCCESS.equals(jedis.set(key, requestId, params));
        } catch (Exception e) {
            log.error("jedis 获取锁失败, key[{}]", key, e);
            throw new ServiceException(ResultCode.REDIS_ERROR);
        }
    }

    /**
     * 获取锁
     *
     * @param key
     * @param requestId
     * @param expireTime
     * @throws Exception
     */
    public void tryLock(String key, String requestId, long expireTime) throws Exception {
        long waitAlready = 0;
        long waitMillisPer = 100;

        try (Jedis jedis = jedisPool.getResource()) {
            while (waitAlready < expireTime) {
                SetParams params = new SetParams();
                params.px(expireTime);
                params.nx();
                String result = jedis.set(key, requestId, params);
                if (SUCCESS.equals(result)) {
                    break;
                }
                Thread.sleep(waitMillisPer);
                waitAlready += waitMillisPer;
            }
        } catch (Exception e) {
            log.error("jedis 尝试获取锁失败, key[{}]", key, e);
            throw new ServiceException(ResultCode.REDIS_ERROR);
        }
    }

    /**
     * 释放锁
     *
     * @param key
     * @param requestId
     * @throws Exception
     */
    public void unlock(String key, String requestId) {
        try (Jedis jedis = jedisPool.getResource()) {
            String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
            Object result = jedis.eval(script, Collections.singletonList(key), Collections.singletonList(requestId));
            if (!RELEASE_SUCCESS.equals(result)) {
                throw new ServiceException(ResultCode.REDIS_ERROR);
            }
        } catch (Exception e) {
            log.error("jedis 解锁失败, key[{}]", key, e);
        }
    }

    /**
     * 是否存在key
     *
     * @param key
     * @return
     */
    public boolean exist(String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.exists(key);
        } catch (Exception e) {
            log.error("jedis 解锁失败, key[{}]", key, e);
            throw new ServiceException(ResultCode.REDIS_ERROR);
        }
    }
}
