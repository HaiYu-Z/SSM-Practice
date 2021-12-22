package com.atguigu.ssm.service.api;

import com.atguigu.ssm.entity.Emp;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface EmpService {

    List<Emp> getAll();

    PageInfo<Emp> getPageInfo(Integer pageNo);
}
