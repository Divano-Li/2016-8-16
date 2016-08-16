package com.bean;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class inputCustomer {
	
	public customer inputC(){
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
			} catch (ParseException e) {
				e.printStackTrace();
			}
		customer c = new customer(1,fname,lname,email,addressid,date);
		return c;

		
	}

}
