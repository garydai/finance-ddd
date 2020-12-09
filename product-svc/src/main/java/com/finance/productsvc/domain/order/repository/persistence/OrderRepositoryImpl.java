package com.finance.productsvc.domain.order.repository.persistence;

import com.finance.productsvc.domain.order.repository.facade.OrderRepositoryInterface;
import com.finance.productsvc.domain.order.repository.mapper.OrderDao;
import com.finance.productsvc.domain.order.repository.po.OrderPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author daitechang
 * @create: 2020-12-09
 **/
@Service
public class OrderRepositoryImpl implements OrderRepositoryInterface {

    @Autowired
    OrderDao orderDao;

    /**
     * 插入订单
     *
     * @param orderPO
     */
    @Override
    public void insert(OrderPO orderPO) {
        orderDao.insert(orderPO);
    }
}
