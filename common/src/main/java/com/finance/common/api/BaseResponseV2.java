package com.finance.common.api;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author daitechang
 */
@Data
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponseV2<T> {
    private String message;
    private int code;

    public T data;

    public BaseResponseV2(Object result) {
        if (result instanceof List) {
            Map<String, Object> map = new HashMap<>();
            map.put("list", result);
            this.data = (T) map;
        } else {
            this.data = (T) result;
        }

        code = ResultCode.SUCCESS.getCode();
        message = ResultCode.SUCCESS.getMsg();
    }

    public BaseResponseV2(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMsg();
    }

    public static BaseResponseV2 success() {
        return new BaseResponseV2(ResultCode.SUCCESS);
    }

    public static BaseResponseV2 fail() {
        return new BaseResponseV2(ResultCode.INTERNAL_ERROR);
    }
}
