package com.finance.common.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author daitechang
 * @create: 2020-08-18
 **/
@Getter
@AllArgsConstructor
public enum ResultCode {
    SUCCESS(200, "Success"),

    FAIL(500, "Fail");

    private final int code;

    private final String msg;
}
