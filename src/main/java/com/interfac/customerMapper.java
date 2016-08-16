package com.interfac;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.bean.customer;

public interface customerMapper {

	@Insert("insert into customer(store_id,first_name,last_name,email,address_id,create_date)"
			+ "values(1,#{first_name},#{last_name},#{email},#{address_id},#{create_date})")
	public int addCus(customer c);

	@Delete("delete from customer where customer_id = #{id}")
	public int deleteCus(int id);

	public int updateCus(int id);

//	 @Select("select first_name,last_name,email,address_id,create_date "
//	 +
//	 "from customer where store_id = 1 and first_name = #{first_name}" )
//	 public List<customer> getCus(String first_name);

	@Select("select customer_id,first_name,last_name,email,address_id,create_date "
			+ "from customer where first_name = #{name} and store_id = 1")
	public List<customer> getCus(String name);
	
	@Select("select * from customer where customer_id = #{id}")
	public customer getCusById(int id);

	public List<customer> getAll();

}
