
package com.ibx.project.smartschools.Examples;


public class ImmutableExample {
	public ImmutableExample() {
	}

	public static void main(String str[]) {
		Employee e = new Employee("CHCP14950");
		System.out.println("" + e.pancardNumber);

	}

}

final class Employee {
	final String pancardNumber;

	public Employee(String pancardNumber) {
		this.pancardNumber = pancardNumber;
	}

	public String getPancardNumber() {
		return pancardNumber;
	}

}