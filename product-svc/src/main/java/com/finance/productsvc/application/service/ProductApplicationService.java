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

    /**
     * 产品列表
     *
     * @param searchCondition
     * @return
     */
    public List<Product> listProduct(SearchCondition searchCondition) {
        return productDomainService.listProduct(searchCondition);
    }

    /**
     * 产品详情
     *
     * @param productId
     * @return
     */
    public Product getProduct(Integer productId) {
        return productDomainService.getProduct(productId);
    }
}
