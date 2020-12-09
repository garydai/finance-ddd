package com.finance.productsvc.domain.product.service;

import com.finance.productsvc.domain.product.entity.Product;
import com.finance.productsvc.domain.product.entity.valueobject.SearchCondition;
import com.finance.productsvc.domain.product.repository.facade.ProductRepositoryInterface;
import com.finance.productsvc.domain.product.repository.po.ProductPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author daitechang
 * @create: 2020-12-08
 **/
@Service
public class ProductDomainService {

    @Autowired
    ProductRepositoryInterface productRepositoryInterface;

    @Autowired
    ProductFactory productFactory;

    public List<Product> listProduct(SearchCondition searchCondition) {
        List<ProductPO> list = productRepositoryInterface.listProduct(searchCondition);
        return Optional.ofNullable(list)
                .orElse(new ArrayList<>())
                .stream()
                .map(item -> productFactory.createProductDO(item))
                .collect(Collectors.toList());
    }

    public Product getProduct(Integer id) {
        return productFactory.createProductDO(productRepositoryInterface.findProduct(id));
    }
}
