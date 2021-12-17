package com.atguigu.mvc.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author HaiYu
 * @date 2021/12/18 23:16
 */
@Controller
public class Demo02 {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/from/redisplay/simple")
    public String demo01(Model model) {

        return "form-simple";
    }
}
