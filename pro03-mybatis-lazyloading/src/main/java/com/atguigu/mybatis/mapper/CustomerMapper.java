package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.entity.Customer;

public interface CustomerMapper {

    Customer selectCustomerWithOrderTowStep(Integer orderId);
}
