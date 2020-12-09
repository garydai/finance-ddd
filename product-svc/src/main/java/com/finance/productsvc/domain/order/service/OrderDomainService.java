package com.finance.productsvc.domain.order.service;

import com.finance.productsvc.domain.order.entity.Order;
import com.finance.productsvc.domain.order.repository.facade.OrderRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author daitechang
 * @create: 2020-12-09
 **/
@Service
public class OrderDomainService {

    @Autowired
    OrderRepositoryInterface orderRepositoryInterface;

    @Autowired
    OrderFactory orderFactory;

    public void createOrder(Order order) {
        orderRepositoryInterface.insert(orderFactory.createOrderPO(order));
    }
}
