package com.atguigu.mybatis.dao;

import com.atguigu.mybatis.bean.Order;

public interface OrderMapper {
    Order selectOrderWithCustomer(Integer orderId);
}
