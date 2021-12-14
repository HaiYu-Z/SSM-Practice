package com.atguigu.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 
 * @author HaiYu
 * @date 2021/12/12 10:51
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "orderList")
public class Customer {
    private Integer customerId;
    private String customerName;

    private List<Order> orderList;

}
