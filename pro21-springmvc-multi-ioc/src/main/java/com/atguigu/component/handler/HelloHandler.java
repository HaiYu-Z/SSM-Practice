package com.atguigu.component.handler;

import com.atguigu.component.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloHandler {

    @Autowired
    private HelloService helloService;
    
    @RequestMapping("/hello/world")
    public String helloWorld(Model model) {
        String message = helloService.getMessage();
        model.addAttribute("message", message);
        return "target";
    }
}
