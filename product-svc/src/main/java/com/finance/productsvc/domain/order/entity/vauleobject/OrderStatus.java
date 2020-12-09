package com.finance.productsvc.domain.order.entity.vauleobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

/**
 * 订单状态
 *
 * @author daitechang
 * @create: 2020-12-09
 **/
@Getter
@AllArgsConstructor
public enum OrderStatus {
    /**
     * 审核
     */
    AUDIT("0"),
    /**
     * 发布
     */
    ANNOUNCE("1");

    private final String code;
}
