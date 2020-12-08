package com.finance.common.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;

/**
 * @ Author     ：sunpz
 * @ Date       ：Created in 08:58 2019-05-27
 * @ Description：
 * @ Modified By：
 * @ Version    : 1.0
 */
public class DESUtils {

    /**
     * 加密算法,可用 DES,DESede,Blowfish.
     */
    private final static String ALGORITHM = "DES";


    /**
     * DES解密算法
     *
     * @param data
     * @param cryptKey 密钥 要是偶数
     * @return
     * @throws Exception
     */
    public static String decrypt(String data,
                                 String cryptKey)
            throws Exception {
        return new String(decrypt(hex2byte(data.getBytes()), cryptKey.getBytes()));
    }

    /**
     * DES加密算法
     *
     * @param data
     * @param cryptKey
     * @return
     * @throws Exception
     */
    public final static String encrypt(String data,
                                       String cryptKey)
            throws Exception {
        return byte2hex(encrypt(data.getBytes(), cryptKey.getBytes()));
    }

    /**
     * des 加密
     *
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    private static byte[] encrypt(byte[] data,
                                  byte[] key)
            throws Exception {
        // DES算法要求有一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
        // 从原始密匙数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);
        // 创建一个密匙工厂，然后用它把DESKeySpec转换成
        // 一个SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        SecretKey securekey = keyFactory.generateSecret(dks);
        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
        // 现在，获取数据并加密
        // 正式执行加密操作
        return cipher.doFinal(data);
    }

    /**
     * des 解密
     *
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    private static byte[] decrypt(byte[] data,
                                  byte[] key)
            throws Exception {
        // DES算法要求有一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
        // 从原始密匙数据创建一个DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);
        // 创建一个密匙工厂，然后用它把DESKeySpec对象转换成
        // 一个SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        SecretKey securekey = keyFactory.generateSecret(dks);
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
        // 现在，获取数据并解密
        // 正式执行解密操作
        return cipher.doFinal(data);
    }

    private static byte[] hex2byte(byte[] b) {
        if ((b.length % 2) != 0) {
            throw new IllegalArgumentException("长度不是偶数");
        }
        byte[] b2 = new byte[b.length / 2];
        for (int n = 0; n < b.length; n += 2) {
            String item = new String(b, n, 2);
            b2[n / 2] = (byte) Integer.parseInt(item, 16);
        }
        return b2;
    }

    private static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }

        }
        return hs.toUpperCase();
    }


    public static void main(String[] args) throws Exception {

//        String mw = "18698577236_18698577236_hzsmk.h5_1491358627331";
//        String key = "1qaz2wsx3edc";
//        String data ="C1A9C30CF697A04A2ADB1AAF9BB730A0288CE5C16EFB8349539C3361ABF3BD14C1EF2A92A7CAE6C7F1F1ECCBF81A2870";
//        System.out.println(DESUtils.decrypt(data, key));
//        System.out.println(DESUtils.encrypt(mw, key));

        String tojen = "B43087CAA155F81AE67E93440A14406028429E350BDF410B5E12ADA815FFE6B088D5464D713596E2B72ED1C12360E824BB7D328B0B2FB2A5D6E2834A57DE71C8DBABFAB9EAD72D29";
        System.out.println(DESUtils.decrypt(tojen, "mCscVPMsYFxy"));


    }
}
