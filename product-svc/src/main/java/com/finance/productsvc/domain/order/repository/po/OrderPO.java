package com.finance.productsvc.domain.order.repository.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;

/**
 * @author daitechang
 * @create: 2020-12-09
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("demand_apply")
@ToString
public class OrderPO {
    /**
     * 订单id
     */
    Integer id;
    /**
     * 产品id
     */
    Integer productId;
    /**
     * 用户id
     */
    Integer userId;
    /**
     * 期望信贷金额
     */
    BigDecimal expecteAmount;
    /**
     * 订单号
     */
    String orderNum;
}
