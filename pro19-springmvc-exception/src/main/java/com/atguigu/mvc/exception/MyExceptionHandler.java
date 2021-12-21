package com.atguigu.mvc.exception;

import com.atguigu.mvc.util.MVCUtil;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 
 * @author HaiYu
 * @date 2021/12/20 21:20
 */
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public String resolveNullPointerException(Exception e, Model model) {
        model.addAttribute("Exception", e);
        return "error-nullpointer";
    }

    @ExceptionHandler(Exception.class)
    public String resolveException(Exception e, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        boolean judgeRequest = MVCUtil.judgeRequestType(request);
        if (judgeRequest) {
            String message = e.getMessage();
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write(message);
            return null;
        }
        model.addAttribute("Exception", e);
        return "error-exception";
    }
}
