package com.finance.productsvc.domain.product.repository.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author daitechang
 * @create: 2020-12-08
 **/
@Data
@TableName("finance_product")
public class ProductPO {

    String id;

    String productName;
}
