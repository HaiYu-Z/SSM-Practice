package com.atguigu.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author HaiYu
 * @date 2021/12/17 10:21
 */
@Repository
public class EmpDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void updateEmpNameById(Integer empId, String empName) {
        String sql = "update t_emp set emp_name = ? where emp_id = ?";
        jdbcTemplate.update(sql, empName, empId);
    }

    public void updateEmpSalaryBuId(Integer empId, Double Salary) {
        String sql = "update t_emp set emp_salary = ? where emp_id = ?";
        jdbcTemplate.update(sql, Salary, empId);
    }

    public String selectEmpNameById(Integer empId) {
        String sql = "select emp_name from t_emp where emp_id = ?";
        return jdbcTemplate.queryForObject(sql, String.class ,empId);
    }
}
