package com.atguigu.ssm.service.impl;

import com.atguigu.ssm.entity.Emp;
import com.atguigu.ssm.mapper.EmpMapper;
import com.atguigu.ssm.service.api.EmpService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    @Override
    public PageInfo<Emp> getPageInfo(Integer pageNo) {
        // 1、确定每页显示数据的条数
        int pageSize = 5;
        // 2、设定分页数据：开启分页功能。开启后，后面执行的 SELECT 语句会自动被附加 LIMIT 子句
        PageHelper.startPage(pageNo, pageSize);
        // 3、正常执行查询
        List<Emp> empList = empMapper.getAll();
        // 4、封装为 PageInfo 对象返回
        return new PageInfo<>(empList);
    }
}
