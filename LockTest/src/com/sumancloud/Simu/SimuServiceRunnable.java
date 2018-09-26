package com.sumancloud.Simu;

/**
 * 用于多线程调用
 * @author zhoujian
 *
 */
public class SimuServiceRunnable implements Runnable {

  

    @Override
    public void run() {
    	
    	SimuService s = new SimuService();
        s.getNumber();
    }

}