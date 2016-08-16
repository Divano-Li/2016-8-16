package com.interfac;

import java.util.List;

import com.bean.address;

public interface addressMapper {
	
	public int addAddr();
	
	public int deleteAddr(int id);
	
	public int updateAddr(int id);
	
	public address getAddr(int id);
	
	public List<address> getAll();

}
