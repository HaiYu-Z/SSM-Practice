package com.atguigu.mvc.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

/**
 * 
 * @author HaiYu
 * @date 2021/12/18 18:59
 */
@Controller
public class Demo01 {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ServletContext servletContext;

    // @RequestMapping("/")
    // public String showPortal() {
    //     return "index";
    // }
    //
    // @RequestMapping("/index.html")
    // public String showIndex() {
    //     return "index";
    // }

    @RequestMapping("/demo01")
    public String demo01(HttpSession session) {
        logger.debug(session.getServletContext().toString());
        logger.debug(this.servletContext.toString());
        return "target";
    }



    @RequestMapping("/request/model")
    public String requestModel(Model model, HttpSession session) {
        model.addAttribute("requestName", "requestHaiYu");
        session.setAttribute("sessionName","sessionHaiYu");
        servletContext.setAttribute("applicationName","applicationHaiYu");
        return "target";
    }
}
