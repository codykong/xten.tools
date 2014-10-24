package com.generaltest.bean;

public class OldTestObject implements Comparable<OldTestObject> {
	
	public OldTestObject(int pk, String name) {
		
		this.pk=pk;
		this.name=name;
	}
	
	private int pk;
	private String name;
	
	public int getPk() {
		return pk;
	}
	public void setPk(int pk) {
		this.pk = pk;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString(){
		return "The Object is {pk="+pk+",name="+name+"}";
	}
	@Override
	public int compareTo(OldTestObject o) {
		
		if(pk<o.getPk()) return -1;
		if(pk>o.getPk()) return 1;
		return 0;
	}

}
