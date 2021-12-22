package com.atguigu.ssm.handler;

import com.atguigu.ssm.entity.Emp;
import com.atguigu.ssm.service.api.EmpService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class EmpHandler {

    @Autowired
    private EmpService empService;

    @RequestMapping("/get/all")
    public String getAll(Model model) {
        List<Emp> empList = empService.getAll();
        model.addAttribute("empList", empList);
        return "emp-list";
    }

    @RequestMapping("/get/page/{pageNo}")
    public String getPage(@PathVariable("pageNo") Integer pageNo,
                          Model model) {
        // pageInfo 对象封装了和分页相关的所有信息
        PageInfo<Emp> pageInfo = empService.getPageInfo(pageNo);
        model.addAttribute("pageInfo",pageInfo);
        return "emp-page";
    }
}
