package com.sumancloud.Simu;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SimuService {

    // 定义锁对象
    private  Lock lock = new ReentrantLock();
    
    //用于查看单列模式是否开启
    private  int count = 0;
    
    private  SimulDao dao;
    
     SimuService() {
    	this.dao = new SimulDao();
    }

    public void getNumber() {
    	System.out.println("==========================getNumber()被调用次数:"+count++);
    	int limit = 0;
        while (limit<50) {
            try {
            	
                // 加锁
            	System.out.println(Thread.currentThread().getName()+ "试图加锁");
                lock.lock();
            	System.out.println(Thread.currentThread().getName()+ "加锁成功，开始处理业务");
                int current = dao.getBillNumber();
                System.out.println(Thread.currentThread().getName()+ "得到当前单据号"+current);
   
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                	System.out.println(Thread.currentThread().getName()+ "出现异常");         
                    e.printStackTrace();
                }
                
                System.out.println("---------------------->"+Thread.currentThread().getName()
                        + "正在生成" + (current++) + "张单据");
                dao.setBillNumber(current);
                limit ++;
            } finally {
                // 释放锁
            	System.out.println(Thread.currentThread().getName()+ "开始释放锁");           	
                lock.unlock();
            	System.out.println(Thread.currentThread().getName()+ "释放锁成功");   
            }
        }
    }

}