package com.atguigu.mybatis;

import com.atguigu.mybatis.entity.Employee;
import com.atguigu.mybatis.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author HaiYu
 * @date 2021/12/12 19:02
 */
public class MyBatisTest {
    private SqlSession session;

    @Test
    public void testBatchInsert() {
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        List<Employee> empList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            empList.add(new Employee(null,"tiger" + i, 1000.0 * i));
        }
        employeeMapper.batchInsert(empList);
    }


    @Test
    public void testUpdate() {
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        Employee condition = new Employee();
        condition.setEmpId(6);
        condition.setEmpName(null);
        condition.setEmpSalary(3000.0);

        employeeMapper.updateEmpCondition(condition);
    }

    @Test
    public void test() {
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        Employee condition = new Employee(null,"Yu",2001.0);
        List<Employee> list = employeeMapper.selectEmpByCondition(condition);
        list.forEach(System.out::println);
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
