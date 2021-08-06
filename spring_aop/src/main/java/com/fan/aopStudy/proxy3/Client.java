package com.fan.aopStudy.proxy3;

public class Client {
    public static void main(String[] args) {
        //真实角色
        Landlord landlord = new Landlord();

        //代理角色:现在没有

        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler();
        proxyInvocationHandler.setRentHouse(landlord);

        RentHouse proxy = (RentHouse) proxyInvocationHandler.getProxy();
        proxy.rent();
    }
}
