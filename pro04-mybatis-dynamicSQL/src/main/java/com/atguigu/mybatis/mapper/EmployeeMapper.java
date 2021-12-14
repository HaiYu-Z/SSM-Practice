package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {

    List<Employee> selectEmpByCondition(Employee condition);

    void updateEmpCondition(Employee condition);

    void batchInsert(@Param("empList") List<Employee> empList);
}
