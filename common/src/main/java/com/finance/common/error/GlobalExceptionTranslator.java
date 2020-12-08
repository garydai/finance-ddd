package com.finance.common.error;

import com.ecreditpal.common.api.BaseResponse;
import com.finance.common.api.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author daitechang
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionTranslator {

    @ExceptionHandler(ServiceException.class)
    public BaseResponse handleError(ServiceException e) {
        log.error("Service Exception", e);
        return BaseResponse
                .builder()
                .code(e.getResultCode().getCode())
                .message(e.getResultCode().getMsg())
                .build();
    }

    @ExceptionHandler(Throwable.class)
    public BaseResponse handleError(Throwable e) {
        log.error("Throwable Exception", e);
        return new BaseResponse(ResultCode.INTERNAL_ERROR);
    }
}
