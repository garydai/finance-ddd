package com.finance.productsvc.application.service;

import com.finance.productsvc.domain.order.entity.Order;
import com.finance.productsvc.domain.order.service.OrderDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author daitechang
 * @create: 2020-12-09
 **/
@Service
public class OrderApplicationService {

    @Autowired
    OrderDomainService orderDomainService;

    public void createOrder(Order order) {
        orderDomainService.createOrder(order);
    }
}
