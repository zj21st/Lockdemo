package com.sumancloud.service;

public class Run {
    public static void main(String[] args) {
    	SimuService str = new SimuService();
        
        Thread tr1 = new Thread(str, "站点1");
        Thread tr2 = new Thread(str, "站点2");
        Thread tr3 = new Thread(str, "站点3");
        
        //
        System.out.println("站点1开机");
        tr1.start();
        System.out.println("站点2开机");
        tr2.start();
        System.out.println("站点3开机");
        tr3.start();
    }
}