package com.finance.productsvc.interfaces.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author daitechang
 * @create: 2020-12-08
 **/
@Data
public class SearchConditionDTO {
    /**
     * 担保方式
     */
    String guaranteeType;
}
