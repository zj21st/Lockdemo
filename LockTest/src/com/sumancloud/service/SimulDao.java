package com.sumancloud.service;
/**
 * ģ��Dao
 * @author zhoujian
 *
 */
public class SimulDao {
	
	
	public int getBillNumber() {
		return  SimulDB.getCurrent();
	}
		
	public void setBillNumber(int current) {
			SimulDB.setCurrent(current);

	}
}
