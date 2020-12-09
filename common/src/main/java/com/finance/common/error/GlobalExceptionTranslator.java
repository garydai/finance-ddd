package com.finance.common.error;

import com.finance.common.api.BaseResponseV2;
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
    public BaseResponseV2 handleError(ServiceException e) {
        log.error("Service Exception", e);
        return BaseResponseV2
                .builder()
                .code(e.getResultCode().getCode())
                .message(e.getResultCode().getMsg())
                .build();
    }

    @ExceptionHandler(Throwable.class)
    public BaseResponseV2 handleError(Throwable e) {
        log.error("Throwable Exception", e);
        return new BaseResponseV2(ResultCode.INTERNAL_ERROR);
    }
}
