package com.atguigu.mybatis;

import com.atguigu.mybatis.entity.Customer;
import com.atguigu.mybatis.entity.Order;
import com.atguigu.mybatis.mapper.CustomerMapper;
import com.atguigu.mybatis.mapper.OrderMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * 
 * @author HaiYu
 * @date 2021/12/12 19:02
 */
public class MyBatisTest {
    private SqlSession session;


    @Test
    public void test1() {
        CustomerMapper customerMapper = session.getMapper(CustomerMapper.class);
        Customer customer = customerMapper.selectCustomerWithOrderList(1);
        System.out.println(customer);
        customer.getOrderList().forEach(System.out::println);
    }

    @Test
    public void test() {
        OrderMapper orderMapper = session.getMapper(OrderMapper.class);
        Order order = orderMapper.selectOrderWithCustomer(1);
        System.out.println(order);
        System.out.println(order.getCustomer());
    }

    @Test
    public void testQueryOrder() {
        OrderMapper orderMapper = session.getMapper(OrderMapper.class);
        Order order = orderMapper.selectOrderOnly(1);
        System.out.println(order);
    }


    @Before
    public void init() throws IOException {
        session = new SqlSessionFactoryBuilder()
                .build(Resources.getResourceAsStream("mybatis-config.xml"))
                .openSession();
    }

    @After
    public void clear() {
        session.commit();
        session.close();
    }
}
