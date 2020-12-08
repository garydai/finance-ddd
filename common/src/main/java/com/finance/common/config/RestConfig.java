package com.finance.common.config;

import com.finance.common.error.GlobalExceptionTranslator;
import org.springframework.context.annotation.Import;

/**
 * @author daitechang
 * @create: 2020-08-18
 **/
@Import(value = {AppConfig.class, GlobalExceptionTranslator.class})
public class RestConfig {
}
