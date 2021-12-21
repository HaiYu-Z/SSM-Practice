package com.atguigu.mvc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author HaiYu
 * @date 2021/12/19 21:01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    
    private String teacherName;
    private Integer teacherAge;
}
