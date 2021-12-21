package com.atguigu.mvc.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @RequestMapping("/atguigu/upload")
    public String doUpload(@RequestParam("username") String username,
                           @RequestParam("picture") MultipartFile picture) {
        logger.debug("username = " + username);
        logger.debug("fileName = " + picture.getOriginalFilename());
        return "target";
    }
}
