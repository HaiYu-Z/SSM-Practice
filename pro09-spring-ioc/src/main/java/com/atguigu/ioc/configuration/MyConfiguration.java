package com.atguigu.ioc.configuration;

import com.atguigu.ioc.component.SoldierService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author HaiYu
 * @date 2021/12/16 13:41
 */
@Configuration
public class MyConfiguration {

    @Bean
    public SoldierService getSoldierService() {
        return new SoldierService();
    }
}
