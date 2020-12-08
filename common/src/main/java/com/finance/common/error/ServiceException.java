package com.finance.common.error;

import com.finance.common.api.ResultCode;
import lombok.Getter;

/**
 * @author daitechang
 */
public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = 2359327815161832954L;

    @Getter
    private final ResultCode resultCode;

    public ServiceException(ResultCode resultCode) {
        super(resultCode.getMsg());
        this.resultCode = resultCode;
    }
}
