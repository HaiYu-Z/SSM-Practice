package com.atguigu.mvc.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.util.Date;

/**
 * 
 * @author HaiYu
 * @date 2021/12/20 12:12
 */
@Data
public class Product {

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date productDate;

    @NumberFormat(pattern = "####,####,####.##")
    private Double productPrice;
}
