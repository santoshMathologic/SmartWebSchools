package com.ibx.project.smartschools.test;

public class Test {

	int id;
	String name;
	
	public Test(int i,String j) {
		id=i;
		name=j;
	}
	public void display(){
		System.out.print(""+id+ ""+name);
	}
public static void main(String args[]){
	    Test t = new Test(10,"SANTOSH");
	    t.display();
	    
}

}
