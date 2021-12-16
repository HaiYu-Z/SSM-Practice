package com.atguigu.proxy.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 
 * @author HaiYu
 * @date 2021/12/16 15:09
 */
public class LogDynamicProxy<T> {
    
    private T target;

    public LogDynamicProxy(T target) {
        this.target = target;
    }

    public T getProxy() {
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        InvocationHandler handler = (Object proxy, Method method, Object[] args) -> {
            Object targetMethodReturnValue = null;
            try {
                System.out.println("前置通知");
                targetMethodReturnValue = method.invoke(target, args);
                System.out.println("返回通知");

            } catch (Exception e) {
                System.out.println("异常通知");

            } finally {
                System.out.println("后置通知");
            }

            return targetMethodReturnValue;
        };

        T proxy = (T) Proxy.newProxyInstance(classLoader, interfaces, handler);

        return proxy;
    }
}
