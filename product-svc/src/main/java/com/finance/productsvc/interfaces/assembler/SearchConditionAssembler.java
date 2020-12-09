package com.finance.productsvc.interfaces.assembler;

import com.finance.productsvc.domain.product.entity.valueobject.SearchCondition;
import com.finance.productsvc.interfaces.dto.SearchConditionDTO;
import org.springframework.beans.BeanUtils;

/**
 * @author daitechang
 * @create: 2020-12-09
 **/
public class SearchConditionAssembler {
    
    public static SearchCondition toDO(SearchConditionDTO searchConditionDTO) {
        SearchCondition searchCondition = new SearchCondition();
        BeanUtils.copyProperties(searchConditionDTO, searchCondition);
        return searchCondition;
    }
}
