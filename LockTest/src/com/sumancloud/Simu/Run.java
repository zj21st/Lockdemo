package com.sumancloud.Simu;

public class Run {
    public static void main(String[] args) {
    	
    	SimuServiceRunnable runnable = SimuServiceRunnable.getInstance();
        
        Thread tr1 = new Thread(runnable, "站点1");
        Thread tr2 = new Thread(runnable, "站点2");
        Thread tr3 = new Thread(runnable, "站点3");
        
        
        
        
        
        //
        System.out.println("站点1开机");
        tr1.start();
        System.out.println("站点2开机");
        tr2.start();
        System.out.println("站点3开机");
        tr3.start();
    }
}