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
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author HaiYu
 * @date 2021/12/12 19:02
 */
public class MyBatisTest {
    private SqlSession session;


    /**
     * 延迟加载
     * @author HaiYu
     * @date 2021/12/13 11:34
     */
    @Test
    public void test1() throws InterruptedException {
        CustomerMapper customerMapper = session.getMapper(CustomerMapper.class);
        Customer customer = customerMapper.selectCustomerWithOrderTowStep(1);
        System.out.println("CustomerId = " + customer.getCustomerId());
        System.out.println("CustomerName = " + customer.getCustomerName());
        TimeUnit.SECONDS.sleep(3);
        customer.getOrderList().forEach(System.out::println);
    }

    @Test
    public void test() {
        OrderMapper orderMapper = session.getMapper(OrderMapper.class);
        Order order = orderMapper.selectOrderWithCustomerTwoStep(1);
        System.out.println(order);
        System.out.println(order.getCustomer());

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
