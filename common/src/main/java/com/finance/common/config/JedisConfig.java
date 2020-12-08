package com.finance.common.config;

import com.finance.common.utils.JedisClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author daitechang
 * @create: 2020-09-17
 **/
public class JedisConfig {
    @Value("${redis.host}")
    private String host;
    @Value("${redis.port}")
    private Integer port;
    @Value("${redis.password}")
    private String password;
    @Value("${redis.timeout}")
    private Integer timeout;
    @Value("${redis.poolMaxTotal}")
    private Integer poolMaxTotal;
    @Value("${redis.poolMaxIdle}")
    private Integer poolMaxIdle;
    @Value("${redis.poolMaxWait}")
    private Integer poolMaxWait;

    @Bean(name = "jedisPool")
    public JedisPool jedisPool() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(poolMaxTotal);
        config.setMaxIdle(poolMaxIdle);
        config.setMaxWaitMillis(poolMaxWait);
        return new JedisPool(config, host, port, timeout, password);
    }

    @Bean(name = "jedisClient")
    public JedisClient jedisClient() {
        return new JedisClient();
    }
}
