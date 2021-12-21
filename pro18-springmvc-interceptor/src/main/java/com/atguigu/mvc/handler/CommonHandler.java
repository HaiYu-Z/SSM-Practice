package com.atguigu.mvc.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author HaiYu
 * @date 2021/12/20 9:04
 */
@Controller
public class CommonHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/common/request/one")
    public String one() {
        logger.debug("common request one");
        return "target";
    }
}
