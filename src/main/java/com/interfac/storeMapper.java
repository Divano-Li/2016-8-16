package com.interfac;

import com.bean.store;

public interface storeMapper {
	
	public int addStore();
	
	public int deleteStore(int id);
	
	public int updateStore(int id);
	
	public store getStore(int id);
}
