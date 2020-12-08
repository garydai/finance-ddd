package com.finance.productsvc.domain.product.repository.facade;

import com.finance.productsvc.domain.product.repository.po.ProductPO;

import java.util.List;

/**
 * @author daitechang
 * @create: 2020-12-08
 **/
public interface ProductRepositoryInterface {
    /**
     * 列表列表
     *
     * @return
     */
    List<ProductPO> listProduct();

    /**
     * 产品详情
     *
     * @param id
     * @return
     */
    ProductPO findProduct(Integer id);
}
