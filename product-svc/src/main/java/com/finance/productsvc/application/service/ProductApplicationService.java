package com.finance.productsvc.application.service;

import com.finance.productsvc.domain.product.entity.Product;
import com.finance.productsvc.domain.product.entity.valueobject.SearchCondition;
import com.finance.productsvc.domain.product.service.ProductDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author daitechang
 * @create: 2020-12-08
 **/
@Service
public class ProductApplicationService {

    @Autowired
    ProductDomainService productDomainService;

    public List<Product> listProduct(SearchCondition searchCondition) {
        return productDomainService.listProduct(searchCondition);
    }
}
