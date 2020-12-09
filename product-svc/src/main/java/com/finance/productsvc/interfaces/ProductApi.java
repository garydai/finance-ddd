package com.finance.productsvc.interfaces;

import com.finance.common.api.BaseResponseV2;
import com.finance.common.apiversion.APIVersion;
import com.finance.common.error.ServiceException;
import com.finance.productsvc.application.service.ProductApplicationService;
import com.finance.productsvc.interfaces.assembler.SearchConditionAssembler;
import com.finance.productsvc.interfaces.dto.ProductDTO;
import com.finance.productsvc.interfaces.dto.SearchConditionDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author daitechang
 * @create: 2020-12-08
 **/
@RestController
@APIVersion("v1")
@RequestMapping("/products")
@Slf4j
public class ProductApi {

    @Autowired
    ProductApplicationService productApplicationService;

    @GetMapping()
    public BaseResponseV2<List<ProductDTO>> listProducts(SearchConditionDTO searchConditionDTO) throws ServiceException {
        return new BaseResponseV2<>(productApplicationService.listProduct(SearchConditionAssembler.toDO(searchConditionDTO)));

    }
}
