package com.sumancloud.Simu;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SimuService {

    // ����������
    private  Lock lock = new ReentrantLock();
    
    //���ڲ鿴����ģʽ�Ƿ���
    private  int count = 0;
    
    private  SimulDao dao;
    
     SimuService() {
    	this.dao = new SimulDao();
    }

    public void getNumber() {
    	System.out.println("==========================getNumber()�����ô���:"+count++);
    	int limit = 0;
        while (limit<50) {
            try {
            	
                // ����
            	System.out.println(Thread.currentThread().getName()+ "��ͼ����");
                lock.lock();
            	System.out.println(Thread.currentThread().getName()+ "�����ɹ�����ʼ����ҵ��");
                int current = dao.getBillNumber();
                System.out.println(Thread.currentThread().getName()+ "�õ���ǰ���ݺ�"+current);
   
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                	System.out.println(Thread.currentThread().getName()+ "�����쳣");         
                    e.printStackTrace();
                }
                
                System.out.println("---------------------->"+Thread.currentThread().getName()
                        + "��������" + (current++) + "�ŵ���");
                dao.setBillNumber(current);
                limit ++;
            } finally {
                // �ͷ���
            	System.out.println(Thread.currentThread().getName()+ "��ʼ�ͷ���");           	
                lock.unlock();
            	System.out.println(Thread.currentThread().getName()+ "�ͷ����ɹ�");   
            }
        }
    }

}