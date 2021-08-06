package com.fan.aopStudy.proxy3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//之后用这个类自动生成代理类
public class ProxyInvocationHandler implements InvocationHandler {

    //被代理的接口
    private RentHouse rentHouse;

    public void setRentHouse(RentHouse rentHouse) {
        this.rentHouse = rentHouse;
    }

    //处理代理实例并返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //动态代理的本质就是利用反射
        Object result = method.invoke(rentHouse, args);
        return result;
    }

    //得到代理类
    public Object getProxy() {
        Object o = Proxy.newProxyInstance(this.getClass().getClassLoader(), rentHouse.getClass().getInterfaces(), this);
        return o;
    }
}
