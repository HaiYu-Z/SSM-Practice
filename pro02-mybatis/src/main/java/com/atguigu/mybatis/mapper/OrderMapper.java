package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.entity.Order;

public interface OrderMapper {

    Order selectOrderOnly(Integer orderId);

    Order selectOrderWithCustomer(Integer orderId);
}
