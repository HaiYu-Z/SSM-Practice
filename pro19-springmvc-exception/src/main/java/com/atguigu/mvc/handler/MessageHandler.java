package com.atguigu.mvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author HaiYu
 * @date 2021/12/20 19:36
 */
@Controller
public class MessageHandler {
    
    @RequestMapping("/throw/arithmetic/exception")
    public String test() {
        System.out.println(10 / 0);
        return "target";
    }

    @RequestMapping("/throw/nullpointer/exception")
    public String test1() {
        String s = null;
        System.out.println(s.length());
        return "target";
    }

    @RequestMapping("/throw/out/of/index/exception/common")
    public String throwOutIndex() {
        int[] array = new int[10];
        System.out.println(array[10]);
        return "target";
    }

    @ResponseBody
    @RequestMapping("/throw/out/of/index/exception/ajax")
    public String throwOutIndexAjax() {
        int[] array = new int[10];
        System.out.println(array[10]);
        return "message from server";
    }
}
