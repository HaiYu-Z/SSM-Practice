package com.atguigu.ioc.test;

import com.atguigu.ioc.component.SoldierService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * @author HaiYu
 * @date 2021/12/16 14:24
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringJunit {
    
    @Autowired
    private SoldierService soldierService;

    @Test
    public void test() {
        System.out.println(soldierService);
    }
}
