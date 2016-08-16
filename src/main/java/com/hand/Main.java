package com.hand;

import java.io.IOException;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.ognl.ParseException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bean.customer;
import com.interfac.customerMapper;

public class Main {

	public static void main(String[] args) {
		System.out.println("Please input first_name:");
		System.out.println("Please input last_name:");
		System.out.println("Please input email:");
		System.out.println("Please input address_id:");
		Scanner in = new Scanner(System.in);
		String fname = in.nextLine();
		String lname = in.nextLine();
		String email = in.nextLine();
		int addressid = in.nextInt();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd ");  
		String cDate = df.format(new Date());
		Date date = null ;
		try {
				date = (Date) df.parse(cDate);
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}
		customer c = new customer(1,fname,lname,email,addressid,date);
		String r = "ApplicationContext.xml";
		Reader reader;
		SqlSessionFactory fac;
		SqlSession session = null;
		try {
			reader = Resources.getResourceAsReader(r);
			fac = new SqlSessionFactoryBuilder().build(reader);
			session = fac.openSession(false);
			customerMapper map = session.getMapper(customerMapper.class);
			//4
			map.addCus(c);
			
			//5
			List<customer> c1 = map.getCus(fname);
			for(int i = 0;i<c1.size();i++){
			System.out.println("================================");
			System.out.println("ID:\t"+c1.get(i).getCustomer_id());
			System.out.println("FirstName:\t"+c1.get(i).getFirst_name());
			System.out.println("LastName:\t"+c1.get(i).getLast_name());
			System.out.println("EMAIL:\t"+c1.get(i).getEmail());
			System.out.println("ADDRESS:\t"+c1.get(i).getAddress_id());
			
			//9
			boolean flag = false;

			System.out.println("Please input a ID:");
			while(!flag){
				int id = in.nextInt();
				customer c2 = map.getCusById(id);
				if(c2.getCustomer_id()!= 0){
					map.deleteCus(id);
					System.out.println("Successed delete");
					flag = true;
				}else{
					System.out.println("The ID you input not exist,Please re_input:");
				}
			}

			}
			session.commit();
		} catch (IOException e) {
			session.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		
	}

}
