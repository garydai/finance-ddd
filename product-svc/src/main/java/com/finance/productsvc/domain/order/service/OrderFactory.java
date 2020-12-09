package com.finance.productsvc.domain.order.service;

import com.finance.productsvc.domain.order.entity.Order;
import com.finance.productsvc.domain.order.repository.po.OrderPO;
import com.finance.productsvc.infrastructure.util.IdGenerator;
import org.springframework.stereotype.Service;

/**
 * @author daitechang
 * @create: 2020-12-09
 **/
@Service
public class OrderFactory {
    /**
     * 创建订单
     *
     * @param order
     * @return
     */
    OrderPO createOrderPO(Order order) {
        return OrderPO.builder()
                .orderNum(IdGenerator.nextId())
                .productId(order.getProductId())
                .userId(order.getUserId())
                .expecteAmount(order.getExpecteAmount())
                .build();
    }
}
