package com.atguigu.tx.service;

import com.atguigu.tx.dao.EmpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author HaiYu
 * @date 2021/12/17 11:54
 */
@Service
public class EmpService {
    
    @Autowired
    private EmpDao empDao;

    @Transactional
    public void updateTwice(Integer empId, String newName, Double newSalary) {
        empDao.updateEmpNameById(empId, newName);
        empDao.updateEmpSalaryBuId(empId, newSalary);
    }
}
