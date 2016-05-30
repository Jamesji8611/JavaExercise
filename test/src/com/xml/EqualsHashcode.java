package com.xml;

import java.util.HashSet;

public class EqualsHashcode {
	public static void main(String[] args){
		tmp t1 = new tmp(1);
		tmp t2 = new tmp(1);
		
		System.out.println("**************");
		System.out.println("t1.equeals(t2) = " + t1.equals(t2));
		HashSet<tmp> s = new HashSet<tmp>();
		s.add(t1);
		s.add(t2);
		System.out.println("#########" + s);
	}
	
}

class tmp{
	private int id;
	
	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id = id;
	}
	public tmp(int id){
		this.setId(id);
	}
	@Override
	public boolean equals(Object obj){
		if(obj == null){
			return false;
		}
		if(obj == this){//传入比较的是本身
			return true;
		}
		//System.out.println("#####"+this.getClass());
		if(this.getClass() != obj.getClass()){
			return false;
		}
		return (this.getId() == ((tmp)obj).getId());
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.id;
		return result;
	}
}
