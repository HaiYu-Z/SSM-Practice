package com.atguigu.mybatis;

import com.atguigu.mybatis.entity.Employee;
import com.atguigu.mybatis.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * 
 * @author HaiYu
 * @date 2021/12/12 19:02
 */
public class MyBatisTest {
    private SqlSessionFactory factory;


    @Test
    public void test() {
        SqlSession session1 = factory.openSession();
        SqlSession session2 = factory.openSession();

        EmployeeMapper mapper1 = session1.getMapper(EmployeeMapper.class);
        EmployeeMapper mapper2 = session2.getMapper(EmployeeMapper.class);

        Employee employee1 = mapper1.selectEmpById(1);
        System.out.println("employee1 = " + employee1);
        session1.commit();
        session1.close();

        Employee employee2 = mapper2.selectEmpById(1);
        System.out.println("employee2 = " + employee2);
        session2.commit();
        session2.close();
    }

    



    @Before
    public void init() throws IOException {
        factory = new SqlSessionFactoryBuilder()
                .build(Resources.getResourceAsStream("mybatis-config.xml"));
    }
}
