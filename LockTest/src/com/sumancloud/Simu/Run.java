package com.sumancloud.Simu;

public class Run {
    public static void main(String[] args) {
    	
    	SimuServiceRunnable runnable = SimuServiceRunnable.getInstance();
        
        Thread tr1 = new Thread(runnable, "վ��1");
        Thread tr2 = new Thread(runnable, "վ��2");
        Thread tr3 = new Thread(runnable, "վ��3");
        
        
        
        
        
        //
        System.out.println("վ��1����");
        tr1.start();
        System.out.println("վ��2����");
        tr2.start();
        System.out.println("վ��3����");
        tr3.start();
    }
}