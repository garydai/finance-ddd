package com.finance.common.constant;

import java.util.HashMap;

/**
 * @author daitechang
 * @create: 2020-10-09
 **/
public class RiskUtils {
    public static final String DECISION_PASS = "通过";
    public static final String DECISION_REJECT = "拒绝";
    public static final String DECISION_EXCEPTION = "异常";

    /**
     * 调用方映射
     * TODO 放数据库
     */
    public static final HashMap<String, Integer> CNSMR_MAP = new HashMap<String, Integer>();

    static {
        // 个贷
        CNSMR_MAP.put("gd", 1);
        // 微信小程序
        CNSMR_MAP.put("wxxcx", 0);
    }
}
