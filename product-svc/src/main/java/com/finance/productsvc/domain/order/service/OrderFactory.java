package com.finance.productsvc.domain.order.service;

import com.finance.productsvc.domain.order.entity.Order;
import com.finance.productsvc.domain.order.entity.vauleobject.BusType;
import com.finance.productsvc.domain.order.entity.vauleobject.OrderStatus;
import com.finance.productsvc.domain.order.repository.po.OrderPO;
import com.finance.productsvc.infrastructure.util.IdGenerator;
import org.springframework.stereotype.Service;

import java.sql.Date;


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
                .orderNum(IdGenerator.nextId().substring(0, 32))
                .productId(order.getProductId())
                .userId(order.getUserId())
                .expecteAmount(order.getExpecteAmount())
                .createTime(new Date(System.currentTimeMillis()))
                .finishTime(new Date(System.currentTimeMillis()))
                .orgNum(1)
                .status(OrderStatus.ANNOUNCE.getCode())
                .pType(BusType.XYDK.getCode())
                .build();
    }
}
