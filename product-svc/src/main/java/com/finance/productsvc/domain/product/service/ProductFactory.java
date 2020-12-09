package com.finance.productsvc.domain.product.service;

import com.finance.productsvc.domain.product.entity.Product;
import com.finance.productsvc.domain.product.repository.po.ProductPO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * @author daitechang
 * @create: 2020-12-09
 **/
@Service
public class ProductFactory {

    Product createProductDO(ProductPO productPO) {
        Product product = new Product();
        BeanUtils.copyProperties(product, productPO);
        return product;
    }
}
