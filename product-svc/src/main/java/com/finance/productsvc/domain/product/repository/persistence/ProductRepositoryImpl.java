package com.finance.productsvc.domain.product.repository.persistence;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.finance.productsvc.domain.product.entity.valueobject.SearchCondition;
import com.finance.productsvc.domain.product.repository.facade.ProductRepositoryInterface;
import com.finance.productsvc.domain.product.repository.mapper.ProductDao;
import com.finance.productsvc.domain.product.repository.po.ProductPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author daitechang
 * @create: 2020-12-08
 **/
@Repository
public class ProductRepositoryImpl implements ProductRepositoryInterface {

    @Autowired
    ProductDao productDao;

    /**
     * 产品列表
     *
     * @param searchCondition
     * @return
     */
    @Override
    public List<ProductPO> listProduct(SearchCondition searchCondition) {
        return productDao.selectList(new QueryWrapper<ProductPO>()
                .eq("guarantee_type", searchCondition.getGuaranteeType())
        );
    }

    /**
     * 产品详情
     *
     * @param id
     * @return
     */
    @Override
    public ProductPO findProduct(Integer id) {
        return productDao.selectById(id);
    }
}
