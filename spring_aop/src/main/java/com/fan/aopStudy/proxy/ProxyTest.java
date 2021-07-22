package com.fan.aopStudy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args) {

        //目标对象
        TargetInterfaceImpl target = new TargetInterfaceImpl();

        //增强对象
        Advice advice = new Advice();

        /*
          三个参数:
          1. 目标对象类加载器
          2. 目标对象相同的接口字节码对象数组
          3.

          返回值: 就是动态生成的代理对象
         */
        TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {

            //调用代理对象的任何方法, 实质执行的都是invoke方法
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                //前置增强
                advice.before();

                //执行目标方法
                Object invoke = method.invoke(target, args);

                //后置增强
                advice.afterReturning();
                return invoke;
            }
        });

        //调用代理对象的方法
        proxy.save();
    }
}
