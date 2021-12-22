package com.atguigu.component.dao;

import org.springframework.stereotype.Repository;

@Repository
public class HelloDao {
    
    public String getMessage() {
        return "Hello i am Dao";
    }
}
