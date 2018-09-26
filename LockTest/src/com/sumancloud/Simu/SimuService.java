package com.sumancloud.Simu;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SimuService {

    // 定义锁对象
    private static Lock lock = new ReentrantLock();
    
    private static SimulDao dao;
    
    public static SimulDao getDao(){
        if(dao==null){
        	dao=new SimulDao();
        }
        return dao;
    }
    

    public int getNumber() {
        while (true) {
            try {
                // 加锁
            	System.out.println(Thread.currentThread().getName()+ "试图加锁");
                lock.lock();
            	System.out.println(Thread.currentThread().getName()+ "加锁成功，开始处理业务");
                int current = SimuService.getDao().getBillNumber();
                System.out.println(Thread.currentThread().getName()+ "得到当前单据号"+current);
                if ( current < 50) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    	System.out.println(Thread.currentThread().getName()+ "出现异常");         
                        e.printStackTrace();
                    }
                    
                    System.out.println("---------------------->"+Thread.currentThread().getName()
                            + "正在生成" + (current++) + "张单据");
                    SimuService.getDao().setBillNumber(current);
                }
            } finally {
                // 释放锁
            	System.out.println(Thread.currentThread().getName()+ "开始释放锁");           	
                lock.unlock();
            	System.out.println(Thread.currentThread().getName()+ "释放锁成功");   
            }
        }
    }

}