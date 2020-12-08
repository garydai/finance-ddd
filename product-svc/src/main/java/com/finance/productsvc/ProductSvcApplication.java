package com.finance.productsvc;

import com.finance.common.config.RestConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author daitechang
 * @create: 2020-12-08
 **/
@SpringBootApplication
@Import(value = RestConfig.class)
public class ProductSvcApplication {
}