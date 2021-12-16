package com.atguigu.proxy.test;

import com.atguigu.proxy.api.Calculator;
import com.atguigu.proxy.impl.CalculatorPureImpl;
import com.atguigu.proxy.impl.LogDynamicProxy;
import org.junit.Test;

/**
 * 
 * @author HaiYu
 * @date 2021/12/16 15:40
 */
public class MyProxyTest {
    
    @Test
    public void test() {
        Calculator target = new CalculatorPureImpl();

        LogDynamicProxy<Calculator> factory = new LogDynamicProxy<>(target);

        int add = factory.getProxy().add(10, 2);
        int sub = factory.getProxy().sub(10, 2);
        int mul = factory.getProxy().mul(10, 2);
        int div = factory.getProxy().div(10, 0);
    }
}
