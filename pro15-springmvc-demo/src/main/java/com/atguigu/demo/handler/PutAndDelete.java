package com.atguigu.demo.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * @author HaiYu
 * @date 2021/12/19 14:47
 */
@Controller
public class PutAndDelete {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/emp",method = RequestMethod.PUT)
    public String PUT(@RequestParam("msg") String msg) {
        logger.debug("PUT请求");
        logger.debug("msg = " + msg);
        return "redirect:/";
    }

    @RequestMapping(value = "/emp",method = RequestMethod.DELETE)
    public String DELETE() {
        logger.debug("DELETE请求");
        return "index";
    }
}
