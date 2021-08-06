package com.fan.aopStudy.proxy3_2;

public class Client {
    public static void main(String[] args) {
        //真实对象
        UserServiceImpl userService = new UserServiceImpl();

        //代理角色, 不存在

        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler();

        //设置要代理的对象
        proxyInvocationHandler.setTarget(userService);

        //动态生成代理类
        UserService proxy = (UserService) proxyInvocationHandler.getProxy();
        proxy.add();
        proxy.query();
    }
}
