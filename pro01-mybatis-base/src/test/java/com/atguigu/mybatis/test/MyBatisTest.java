package com.atguigu.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * 
 * @author HaiYu
 * @date 2021/12/11 13:37
 */
public class MyBatisTest {
    @Test
    public void testHelloWorld() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        SqlSession session = factory.openSession();

        String statement = "com.atguigu.com.atguigu.mybatis.dao.EmployeeMapper.selectEmployee";
        Integer empId = 1;
        Object o = session.selectOne(statement, empId);
        System.out.println(o);

        session.commit();
        session.close();
    }
}
