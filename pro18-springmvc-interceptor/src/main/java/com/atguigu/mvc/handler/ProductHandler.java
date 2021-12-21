package com.atguigu.mvc.handler;

import com.atguigu.mvc.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author HaiYu
 * @date 2021/12/20 12:22
 */
@Controller
public class ProductHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/save/product")
    private String saveProduct(Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "error";
        }
        logger.debug(product.toString());
        return "target";
    }
}
