package com.finance.productsvc.domain.product.repository.facade;

import com.finance.productsvc.domain.product.entity.valueobject.SearchCondition;
import com.finance.productsvc.domain.product.repository.po.ProductPO;

import java.util.List;

/**
 * @author daitechang
 * @create: 2020-12-08
 **/
public interface ProductRepositoryInterface {

    /**
     * 产品列表
     *
     * @param searchCondition
     * @return
     */
    List<ProductPO> listProduct(SearchCondition searchCondition);

    /**
     * 产品详情
     *
     * @param id
     * @return
     */
    ProductPO findProduct(Integer id);
}
