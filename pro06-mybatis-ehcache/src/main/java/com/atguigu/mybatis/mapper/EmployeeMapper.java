package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.entity.Employee;

public interface EmployeeMapper {

    Employee selectEmpById(Integer empId);
}
