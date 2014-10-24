package com.generaltest.bean;

public class Employee implements Cloneable {

	private int id;
	
	private String name;
	
	private int age;
	
	
	public Employee clone() throws CloneNotSupportedException{
		
			return (Employee) super.clone();
		
	}
	
	public String toString(){
		
		
		return "id="+id+",name="+name+",age="+age;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
