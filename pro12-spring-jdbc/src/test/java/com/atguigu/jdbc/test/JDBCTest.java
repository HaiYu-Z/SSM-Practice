package com.atguigu.jdbc.test;

import com.atguigu.tx.dao.EmpDao;
import com.atguigu.tx.service.EmpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * @author HaiYu
 * @date 2021/12/17 9:22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class JDBCTest {
    @Autowired
    private EmpDao empDao;
    @Autowired
    private EmpService empService;

    @Test
    public void test1() {
        empService.updateTwice(2,"Yu",2222.22);
    }

    @Test
    public void test() {
        System.out.println(empDao.selectEmpNameById(1));
        empDao.updateEmpNameById(7,"Yu");
        empDao.updateEmpSalaryBuId(7,6666.66);
    }
}
