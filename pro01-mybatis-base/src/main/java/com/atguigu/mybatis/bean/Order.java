package com.atguigu.mybatis.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author HaiYu
 * @date 2021/12/12 10:49
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private Integer orderId;
    private String orderName;
    private Integer customerId;
    private Customer customer;
}
