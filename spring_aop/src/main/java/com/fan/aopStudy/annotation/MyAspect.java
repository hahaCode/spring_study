package com.fan.aopStudy.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect  //表示当前类是切面类
public class MyAspect {

    @Before("execution(* com.fan.aopStudy.annotation.*.*(..))")
    public void before() {
        System.out.println("前置增强.....");
    }

    @After("pointcut()")
    //@After("MyAspect.pointcut()")
    public void afterReturning() {
        System.out.println("后置增强......");
    }

    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕前....");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("环绕后....");
        return proceed;
    }

    //定义一个切点表达式
    @Pointcut("execution(* com.fan.aopStudy.annotation.*.*(..))")
    public void pointcut() {}
}
