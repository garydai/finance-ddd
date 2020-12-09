package com.finance.productsvc.domain.order.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.finance.productsvc.domain.order.repository.po.OrderPO;
import org.springframework.stereotype.Service;

/**
 * @author daitechang
 * @create: 2020-12-09
 **/
public interface OrderDao extends BaseMapper<OrderPO> {
}
