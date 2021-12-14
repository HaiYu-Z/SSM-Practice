package com.atguigu.mybatis.dao;

import com.atguigu.mybatis.bean.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {

    Employee selectEmployee(Integer empId);

    int insertEmp(Employee employee);

    void updateByMap(Map<String, Object> paramMap);

    Long selectCount();

    List<Employee> selectAll();

    int insertWithKey(Employee employee);

    List<Employee> selectWithResultMap();
}
