package com.atguigu.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 
 * @author HaiYu
 * @date 2021/12/16 18:02
 */
@Aspect
@Component
@Order(2)
public class LogAspect {

    @Pointcut("execution(* *..Calculator.*(..))")
    private void pointcut(){}

    @Before("pointcut()")
    public void printLogBeforeCore(JoinPoint joinPoint) {
        System.out.println("# aop前置通知");
        System.out.println(Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(value = "pointcut()",
                    returning = "result")
    public void printLogAfterSuccess(Object result) {
        System.out.println("# aop返回通知");
        System.out.println("切面类 result = " + result);
    }

    @AfterThrowing(value = "pointcut()",
                    throwing = "e")
    public void printLogAfterException(Exception e) {
        System.out.println("# aop异常通知");
    }

    @After("pointcut()")
    public void printLogFinalEnd() {
        System.out.println("# aop后置通知");
    }
}
