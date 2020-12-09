package com.finance.productsvc.interfaces.dto;

import lombok.Data;

/**
 * @author daitechang
 * @create: 2020-12-08
 **/
@Data
public class ProductDTO {
    /**
     * 担保方式
     */
    String guaranteeType;

    /**
     * 产品名称
     */
    String productName;
}
