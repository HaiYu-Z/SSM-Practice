package com.atguigu.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 
 * @author HaiYu
 * @date 2021/12/16 22:22
 */
@Aspect
@Component
@Order(1) // 控制当前切面的优先级
public class TxAspect {

    // 使用Around注解标明环绕通知的方法
    @Around("execution(* *..Calculator.*(..))")
    public Object manageTransaction(ProceedingJoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Object returnValue = null;
        try {
            System.out.println("前置通知");
            returnValue = joinPoint.proceed(args);
            System.out.println("返回通知");

        } catch (Throwable e) {
            System.out.println("异常通知");

        } finally {
            System.out.println("后置通知");
        }
        return returnValue;
    }
}
