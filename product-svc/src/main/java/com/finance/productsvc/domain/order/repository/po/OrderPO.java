package com.finance.productsvc.domain.order.repository.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;

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
    @TableId(type = IdType.AUTO)
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
    /**
     * 创建时间
     */
    Date createTime;
    /**
     * 截止时间
     */
    Date finishTime;
    /**
     * 现存接单机构数
     */
    Integer orgNum;
    /**
     * 需求状态
     */
    String status;
    /**
     * 业务类型
     */
    Integer pType;
}
