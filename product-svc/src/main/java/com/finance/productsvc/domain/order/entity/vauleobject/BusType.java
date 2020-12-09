package com.finance.productsvc.domain.order.entity.vauleobject;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 业务类型
 *
 * @author daitechang
 * @create: 2020-12-09
 **/
@Getter
@AllArgsConstructor
public enum BusType {
    /**
     * 信用贷款
     */
    XYDK(0),
    /**
     * 小额贷款公司
     */
    XEDK(1);

    private final int code;
}
