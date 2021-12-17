package com.atguigu.tx.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * 
 * @author HaiYu
 * @date 2021/12/17 10:19
 */
@Component
@Data
public class Emp {
    
    private Integer empId;
    private String empName;
    private String empSalary;
}
