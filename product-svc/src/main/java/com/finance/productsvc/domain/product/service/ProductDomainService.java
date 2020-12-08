package com.finance.productsvc.domain.product.service;

import com.finance.productsvc.domain.product.entity.Product;
import com.finance.productsvc.domain.product.entity.valueobject.SearchCondition;
import com.finance.productsvc.domain.product.repository.facade.ProductRepositoryInterface;
import com.finance.productsvc.domain.product.repository.po.ProductPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author daitechang
 * @create: 2020-12-08
 **/
@Service
public class ProductDomainService {

    @Autowired
    ProductRepositoryInterface productRepositoryInterface;

    public List<Product> listProduct(SearchCondition searchCondition) {
        List<ProductPO> list = productRepositoryInterface.listProduct();
        return ;
    }
}
