package com.sumancloud.service;

public class Run {
    public static void main(String[] args) {
    	SimuService str = new SimuService();
        
        Thread tr1 = new Thread(str, "վ��1");
        Thread tr2 = new Thread(str, "վ��2");
        Thread tr3 = new Thread(str, "վ��3");
        
        //
        System.out.println("վ��1����");
        tr1.start();
        System.out.println("վ��2����");
        tr2.start();
        System.out.println("վ��3����");
        tr3.start();
    }
}