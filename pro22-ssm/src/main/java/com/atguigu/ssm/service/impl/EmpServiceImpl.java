package com.atguigu.ssm.service.impl;

import com.atguigu.ssm.entity.Emp;
import com.atguigu.ssm.mapper.EmpMapper;
import com.atguigu.ssm.service.api.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Transactional(readOnly = true)
    @Override
    public List<Emp> getAll() {
        return empMapper.getAll();
    }
}
