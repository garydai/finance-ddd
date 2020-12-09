package com.finance.productsvc.interfaces;

import com.finance.common.api.BaseResponseV2;
import com.finance.common.api.ResultCode;
import com.finance.common.apiversion.APIVersion;
import com.finance.common.error.ServiceException;
import com.finance.productsvc.application.service.OrderApplicationService;
import com.finance.productsvc.interfaces.assembler.OrderAssembler;
import com.finance.productsvc.interfaces.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author daitechang
 * @create: 2020-12-09
 **/
@RestController
@APIVersion("v1")
@RequestMapping("/orders")
@Slf4j
public class OrderApi {

    @Autowired
    OrderApplicationService orderApplicationService;

    @PostMapping()
    public BaseResponseV2 listProducts(OrderDTO orderDTO) throws ServiceException {
        orderApplicationService.createOrder(OrderAssembler.toDO(orderDTO));
        return new BaseResponseV2(ResultCode.SUCCESS);
    }
}
