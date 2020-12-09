package com.finance.productsvc.domain.product.entity;

import lombok.Data;

/**
 * @author daitechang
 * @create: 2020-12-08
 **/
@Data
public class Product {
    /**
     * 担保方式
     */
    String guaranteeType;

    /**
     * 产品名称
     */
    String productName;
}
