package com.sumancloud.Simu;

/**
 * ���ڶ��̵߳���
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