package com.atguigu.mvc.handler;

import com.atguigu.mvc.entity.Student;
import com.atguigu.mvc.entity.Teacher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author HaiYu
 * @date 2021/12/19 20:06
 */
@Controller
public class AjaxHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ResponseBody
    @RequestMapping("/ajax/experiment/one")
    public String experimentOne(@RequestParam("username") String username,
                                @RequestParam("password") String password) {
        logger.debug("username = " + username);
        logger.debug("password = " + password);
        return "message from handler as response[来自服务器]";
    }

    @ResponseBody
    @RequestMapping("ajax/experiment/two")
    public String experimentTwo(@RequestBody Student student) {
        logger.debug(student.toString());
        return "message from handler as response[来自服务器]";
    }

    @ResponseBody
    @RequestMapping("ajax/experiment/three")
    public Teacher experimentThree() {
        return new Teacher("Tom",20);
    }
}
