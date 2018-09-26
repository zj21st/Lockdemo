package com.sumancloud.Simu;

/**
 * ���ڶ��̵߳���
 * @author zhoujian
 *
 */
public class SimuServiceRunnable implements Runnable {

	private  SimuService service; 
    
    private static SimuServiceRunnable instance;
    private SimuServiceRunnable() {  
    	this.service =  new  SimuService();
    }
    public static SimuServiceRunnable getInstance(){
        if(instance==null){
        	instance=new SimuServiceRunnable();

        }
        return instance;
    }  

    @Override
    public void run() {
    	service.getNumber();
    }

}