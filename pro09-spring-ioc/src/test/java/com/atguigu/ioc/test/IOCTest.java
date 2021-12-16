package com.atguigu.ioc.test;

import com.atguigu.ioc.component.CommonComponent;
import com.atguigu.ioc.component.SoldierController;
import com.atguigu.ioc.component.SoldierDao;
import com.atguigu.ioc.component.SoldierService;
import com.atguigu.ioc.configuration.MyConfiguration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author HaiYu
 * @date 2021/12/16 10:33
 */
public class IOCTest {

    private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    private ApplicationContext iocAnnotation = new AnnotationConfigApplicationContext(MyConfiguration.class);

    @Test
    public void test1() {
        SoldierService soldierService = iocAnnotation.getBean(SoldierService.class);
        System.out.println(soldierService);
    }

    @Test
    public void test() {
        CommonComponent commonComponent = ioc.getBean(CommonComponent.class);
        SoldierController soldierController = ioc.getBean(SoldierController.class);
        SoldierDao soldierDao = ioc.getBean(SoldierDao.class);
        SoldierService soldierService = ioc.getBean(SoldierService.class);

        System.out.println(commonComponent);
        System.out.println(soldierController);
        System.out.println(soldierDao);
        System.out.println(soldierService);
    }
}
