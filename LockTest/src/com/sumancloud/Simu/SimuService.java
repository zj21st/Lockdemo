package com.sumancloud.Simu;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SimuService {

    // ����������
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
                // ����
            	System.out.println(Thread.currentThread().getName()+ "��ͼ����");
                lock.lock();
            	System.out.println(Thread.currentThread().getName()+ "�����ɹ�����ʼ����ҵ��");
                int current = SimuService.getDao().getBillNumber();
                System.out.println(Thread.currentThread().getName()+ "�õ���ǰ���ݺ�"+current);
                if ( current < 50) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    	System.out.println(Thread.currentThread().getName()+ "�����쳣");         
                        e.printStackTrace();
                    }
                    
                    System.out.println("---------------------->"+Thread.currentThread().getName()
                            + "��������" + (current++) + "�ŵ���");
                    SimuService.getDao().setBillNumber(current);
                }
            } finally {
                // �ͷ���
            	System.out.println(Thread.currentThread().getName()+ "��ʼ�ͷ���");           	
                lock.unlock();
            	System.out.println(Thread.currentThread().getName()+ "�ͷ����ɹ�");   
            }
        }
    }

}