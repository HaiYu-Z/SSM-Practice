package com.atguigu.mvc.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author HaiYu
 * @date 2021/12/19 20:59
 */
@Data
public class Student {
    
    private Integer stuId;
    private String stuName;
    private List<Subject> subjectList;
    private Map<String, Teacher> teacherMap;
    private School school;
}
