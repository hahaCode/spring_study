package com.fan.aopStudy.aop;

public class Target implements TargetInterface{
    @Override
    public void save() {
        System.out.println("save......running......");
    }
}
