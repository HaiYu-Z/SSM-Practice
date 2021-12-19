package com.atguigu.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author HaiYu
 * @date 2021/12/19 8:04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    private String movieId;
    private String movieName;
    private Double moviePrice;
}
