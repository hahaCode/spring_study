package com.fan.aopStudy.proxy;

public class TargetInterfaceImpl implements TargetInterface{
    @Override
    public void save() {
        System.out.println("save.....TargetInterfaceImpl......JDK实现");
    }
}
