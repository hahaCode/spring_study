package com.fan.aopStudy.proxy3_2;

import com.fan.aopStudy.proxy3.RentHouse;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//之后用这个类自动生成代理类
public class ProxyInvocationHandler implements InvocationHandler {

    //被代理的接口
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    //得到代理类
    public Object getProxy() {
        Object o = Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        return o;
    }

    //处理代理实例并返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        log(method.getName());
        Object result = method.invoke(target, args);
        return result;
    }

    //这是一个增强方法
    public void log(String msg) {
        System.out.println("执行" + msg + "方法!");
    }
}
