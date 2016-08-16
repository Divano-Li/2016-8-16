package com.interfac;

import com.bean.country;

public interface countryMapper {
	
	public int addCountry();
	
	public int deleteCountry(int id);
	
	public int updateCountry(int id);
	
	public country getCountry(int id);

}
