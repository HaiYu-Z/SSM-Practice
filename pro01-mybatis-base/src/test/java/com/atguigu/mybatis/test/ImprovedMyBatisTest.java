package com.atguigu.mybatis.test;

import com.atguigu.mybatis.bean.Customer;
import com.atguigu.mybatis.bean.Employee;
import com.atguigu.mybatis.bean.Order;
import com.atguigu.mybatis.dao.EmployeeMapper;
import com.atguigu.mybatis.dao.OrderMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author HaiYu
 * @date 2021/12/11 19:52
 */
public class ImprovedMyBatisTest {

    private SqlSession session;
    
    @Test
    public void testGetOrderWithCustomer() {
        OrderMapper orderMapper = session.getMapper(OrderMapper.class);
        Order order = orderMapper.selectOrderWithCustomer(1);
        Customer customer = order.getCustomer();
        System.out.println(order);
        System.out.println(customer);
    }


    @Test
    public void testSelectWithResultMap() {
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        List<Employee> list = mapper.selectWithResultMap();
        list.forEach(System.out::println);
    }


    /**
     * 获取自增主键
     * @author HaiYu
     * @date 2021/12/11 23:13
     */
    @Test
    public void testGetGeneratedKey() {
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

        Employee employee = new Employee(null, "A", 3333.33);
        int rowCount = mapper.insertWithKey(employee);
        System.out.println("rowCount = " + rowCount);

        Integer empId = employee.getEmpId();
        System.out.println("empId = " + empId);
    }


    @Test
    public void testSelectForList() {
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        List<Employee> list = mapper.selectAll();
        list.forEach(System.out::println);
    }


    @Test
    public void testSelectCount() {
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Long count = mapper.selectCount();
        System.out.println("count = " + count);
    }

    @Test
    public void testUpdateEmpByMap() {
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        Map<String, Object> paramMap = new HashMap<>();

        paramMap.put("empId",1);
        paramMap.put("empName","Tom");
        paramMap.put("empSalary",6666.66);

        employeeMapper.updateByMap(paramMap);
    }


    @Test
    public void testInsert() {
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        int rowCount = employeeMapper.insertEmp(new Employee(null, "jerry", 1111.1));
        System.out.println("rowCount = " + rowCount);
    }

    @Test
    public void testSelect() {
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        System.out.println(employeeMapper.getClass().getName());
        Employee employee = employeeMapper.selectEmployee(1);
        System.out.println(employee);
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
