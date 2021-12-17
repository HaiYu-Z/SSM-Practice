package com.atguigu.mvc.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 
 * @author HaiYu
 * @date 2021/12/18 9:41
 */
@Controller
public class HelloHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/")
    public String showPortal() {
        return "portal";
    }

    @RequestMapping(value = "/springmvc")
    public String sayHello(@RequestParam("username") String username,
                           @RequestParam("password") String password) {
        logger.debug("username = " + username);
        logger.debug("password = " + password);
        return "target";
    }

    @RequestMapping("/city")
    public String city(@RequestParam("city") List<String> list) {
        list.forEach(System.out::println);
        return "target";
    }

    @RequestMapping("/forward/hello")
    public String forwardHello() {
        return "forward:hello.html";
    }

    @RequestMapping("/redirect/hello")
    public String redirectHello() {
        return "redirect:/hello.html";
    }
}
