package com.generaltest.innerclass;

import com.generaltest.bean.Employee;

public class Clone {
	
	public static void main(String[] args){
		
		Employee em=new Employee();
		
		em.setAge(5);
		em.setId(1);
		em.setName("aaa");
		
		try {
			Employee copy=em.clone();
			System.out.println(copy.toString());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
