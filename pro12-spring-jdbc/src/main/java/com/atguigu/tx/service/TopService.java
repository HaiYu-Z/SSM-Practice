package com.atguigu.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author HaiYu
 * @date 2021/12/17 20:25
 */
@Service
public class TopService {
    
    @Autowired
    public EmpService empService;

    @Transactional
    public void topTxMethod() {

    }
}
