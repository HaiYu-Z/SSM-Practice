package com.atguigu.ssm.test;

import com.atguigu.ssm.entity.Emp;
import com.atguigu.ssm.mapper.EmpMapper;
import com.atguigu.ssm.service.api.EmpService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig(locations = "classpath:spring-persist.xml")
public class SSMTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpService empService;

    @Test
    public void test1() {
        List<Emp> empList = empService.getAll();
        for (Emp emp : empList) {
            logger.debug(emp.toString());
        }
    }

    @Test
    public void test() {
        List<Emp> empList = empMapper.getAll();
        for (Emp emp : empList) {
            logger.debug(emp.toString());
        }
    }
}
