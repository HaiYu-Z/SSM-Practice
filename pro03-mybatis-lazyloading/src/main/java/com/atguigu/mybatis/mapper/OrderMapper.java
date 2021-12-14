package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.entity.Order;

public interface OrderMapper {

    Order selectOrderWithCustomerTwoStep(Integer orderId);
}
