package com.atguigu.aop.impl;

import com.atguigu.aop.api.Calculator;
import org.springframework.stereotype.Component;

/**
 * 
 * @author HaiYu
 * @date 2021/12/16 15:05
 */
@Component
public class CalculatorPureImpl implements Calculator {

    @Override
    public int add(int i, int j) {
        int result = i + j;
        System.out.println("方法内部 result = " + result);
        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result = i - j;
        System.out.println("方法内部 result = " + result);
        return result;
    }

    @Override
    public int mul(int i, int j) {
        int result = i * j;
        System.out.println("方法内部 result = " + result);
        return result;
    }

    @Override
    public int div(int i, int j) {
        int result = i / j;
        System.out.println("方法内部 result = " + result);
        return result;
    }
}
