package com.fan.aopStudy.proxy3;


public class Landlord implements RentHouse{
    @Override
    public void rent() {
        System.out.println("房东出租房子....");
    }
}
