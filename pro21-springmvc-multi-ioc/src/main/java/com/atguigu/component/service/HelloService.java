package com.atguigu.component.service;

import com.atguigu.component.dao.HelloDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    @Autowired
    private HelloDao helloDao;

    public String getMessage() {
        return helloDao.getMessage();
    }
}
