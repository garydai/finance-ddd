package com.finance.productsvc.interfaces.assembler;

import com.finance.productsvc.domain.order.entity.Order;
import com.finance.productsvc.interfaces.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

/**
 * @author daitechang
 * @create: 2020-12-09
 **/
public class OrderAssembler {

    public static Order toDO(OrderDTO orderDTO) {
        Order order = new Order();
        BeanUtils.copyProperties(orderDTO, order);
        return order;
    }
}
