package com.atguigu.aop.test;

import com.atguigu.aop.api.Calculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * @author HaiYu
 * @date 2021/12/16 16:51
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AOPTest {

    @Autowired
    private Calculator calculator;

    @Test
    public void test() {
        calculator.add(10,2);
        System.out.println("-------------------");
        calculator.sub(10,2);
        System.out.println("-------------------");
        calculator.mul(10,2);
        System.out.println("-------------------");
        calculator.div(10,2);
    }
}
