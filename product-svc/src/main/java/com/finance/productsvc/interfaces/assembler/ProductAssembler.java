package com.finance.productsvc.interfaces.assembler;

import com.finance.productsvc.domain.product.entity.Product;
import com.finance.productsvc.interfaces.dto.ProductDTO;
import org.springframework.beans.BeanUtils;

/**
 * @author daitechang
 * @create: 2020-12-09
 **/
public class ProductAssembler {

    public static ProductDTO toDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(product, productDTO);
        return productDTO;
    }
}
