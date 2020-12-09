package com.finance.productsvc.domain.order.repository.facade;

import com.finance.productsvc.domain.order.repository.po.OrderPO;

/**
 * @author daitechang
 * @create: 2020-12-09
 **/
public interface OrderRepositoryInterface {
    /**
     * 插入订单
     *
     * @param orderPO
     */
    void insert(OrderPO orderPO);
}
