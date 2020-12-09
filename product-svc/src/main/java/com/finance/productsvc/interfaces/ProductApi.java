package com.finance.productsvc.interfaces;

import com.finance.common.api.BaseResponseV2;
import com.finance.common.apiversion.APIVersion;
import com.finance.common.error.ServiceException;
import com.finance.productsvc.application.service.ProductApplicationService;
import com.finance.productsvc.domain.product.entity.Product;
import com.finance.productsvc.interfaces.assembler.ProductAssembler;
import com.finance.productsvc.interfaces.assembler.SearchConditionAssembler;
import com.finance.productsvc.interfaces.dto.ProductDTO;
import com.finance.productsvc.interfaces.dto.SearchConditionDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

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
        List<Product> products = productApplicationService.listProduct(SearchConditionAssembler.toDO(searchConditionDTO));
        return new BaseResponseV2<>(products.stream()
                .map(ProductAssembler::toDTO)
                .collect(Collectors.toList()));

    }

    @GetMapping("/{productId}")
    public BaseResponseV2<ProductDTO> getProduct(@PathVariable Integer productId) throws ServiceException {
        return new BaseResponseV2<>(productApplicationService.getProduct(productId));
    }
}
