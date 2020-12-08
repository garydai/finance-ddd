package com.finance.common.crypto;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @author daitechang
 * @create: 2020-08-17
 **/
@Slf4j
public class Sign {

    private static final String CLAIM_PHONE = "phone";
    private static final String CLAIM_NO = "staffNo";
    private static final String SUBJECT_WECHAT = "wechat";
    private static final String WECHAT_SECRET = "GvZcHfSusPjPWixJVFazAXMHvUytDkyvzuXuiXxcEkizQodwryTYpqmWxdihZHKMXTCuEzGjeYeBFuGqRfozrQakLbrUfobjdNkHAtBpSvxyKpmnllCMqjDjxLsiPcUm";
    private static final long EXPIRED_TIME = 1000 * 3600 * 24 * 365;

    public static boolean verifyAppToken(String tokenString, String phone) {
        Algorithm algorithm = Algorithm.HMAC256(WECHAT_SECRET);
        try {
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim(CLAIM_PHONE, phone)
                    .withSubject(SUBJECT_WECHAT)
                    .build();
            DecodedJWT jwt = verifier.verify(tokenString);
        } catch (Exception e) {
            log.info("wechat token 验证失败 {}, {}, {}", e.getMessage(), tokenString, phone);
            return false;
        }

        return true;
    }

    public static String generateAppToken(String phone) {
        Algorithm algorithm = Algorithm.HMAC256(WECHAT_SECRET);

        return JWT.create()
                .withClaim(CLAIM_PHONE, phone)
                .withSubject(SUBJECT_WECHAT)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRED_TIME))
                .sign(algorithm);
    }

    public static String generateAppToken(String phone,String staffNo) {
        Algorithm algorithm = Algorithm.HMAC256(WECHAT_SECRET);

        return JWT.create()
                .withClaim(CLAIM_PHONE, phone)
                .withClaim(CLAIM_NO,staffNo)
                .withSubject(SUBJECT_WECHAT)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRED_TIME))
                .sign(algorithm);
    }

    public static boolean verifyAppToken(String tokenString, String phone,String staffNo) {
        Algorithm algorithm = Algorithm.HMAC256(WECHAT_SECRET);
        try {
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim(CLAIM_PHONE, phone)
                    .withClaim(CLAIM_NO,staffNo)
                    .withSubject(SUBJECT_WECHAT)
                    .build();
            DecodedJWT jwt = verifier.verify(tokenString);
        } catch (Exception e) {
            log.info("staff token 验证失败 {}, {}, {}", e.getMessage(), tokenString, phone);
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String token = generateAppToken("13900000000");
        System.out.println(verifyAppToken(token, "13900000000"));
        System.out.println(EXPIRED_TIME);
    }
}

