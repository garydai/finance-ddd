package com.finance.productsvc.domain.order.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 需求申请单
 *
 * @author daitechang
 * @create: 2020-12-09
 **/
@Data
public class Order {
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
