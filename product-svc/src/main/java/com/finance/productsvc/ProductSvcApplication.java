package com.finance.productsvc;

import com.finance.common.config.RestConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author daitechang
 * @create: 2020-12-08
 **/
@SpringBootApplication
@Import(value = RestConfig.class)
@MapperScan({"com.finance.productsvc.domain.order.repository.mapper", "com.finance.productsvc.domain.product.repository.mapper"})
public class ProductSvcApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductSvcApplication.class, args);
    }
}
