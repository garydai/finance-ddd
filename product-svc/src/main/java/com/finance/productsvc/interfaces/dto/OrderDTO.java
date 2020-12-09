package com.finance.productsvc.interfaces.dto;

import java.math.BigDecimal;

/**
 * @author daitechang
 * @create: 2020-12-09
 **/
public class OrderDTO {
    /**
     * 产品id
     */
    Integer productId;
    /**
     * 用户id
     */
    Integer userId;
    /**
     * 期望信贷金额
     */
    BigDecimal expecteAmount;
}
