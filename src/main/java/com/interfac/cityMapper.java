package com.interfac;

import com.bean.city;

public interface cityMapper {

	public int addCity();
	
	public int deleteCity(int id);
	
	public int updateCity(int id);
	
	public city getCity(int id);
}
