package com.ibx.project.smartschools.test;

public class Employee {
	int id;
	String name;
	Address address;

	public Employee(int id,String name,Address address) {
		this.id = id;
		this.name= name;
		this.address = address;
	}
	public void display(){
		System.out.println(" "+id+" "+name+" "+address.state+" "+address.city+" "+address.country);
		
	}
	public static void main(String args[]){
		Address addr  = new Address("Bangalore","KA","India");
		Employee e= new Employee(420,"santosh",addr);
		
		e.display();
		
	}

}
