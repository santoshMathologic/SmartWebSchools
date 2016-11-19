/**
 * 
 */
package com.ibx.project.smartschools.Examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author SANTOSH
 *
 */
public class Test {

	/**
	 * 
	 */
	public Test() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @return 
	 */
	
	public static void stringSort(){
		

		List<String> l = new ArrayList<String>();
		l.add("20");
		l.add("8");
		l.add("5");
		Collections.sort(l);
		 System.out.print("String Sort");
		 for(int i = 0;i<l.size();i++){
			 System.out.print(" " +l.get(i));
		 }
		 
	}
	
	public static void integerSort(){
		
		List<Integer> l = new ArrayList<Integer>();
		l.add(20);
		l.add(8);
		l.add(5);
		Collections.sort(l);
		System.out.print("Integer Sort");
		 for(int i = 0;i<l.size();i++){
			 System.out.print(" "+l.get(i));
		 }
		
	}
	public static void main(String[] args) {
		
		
	
	  integerSort();
	  System.out.println();
	  stringSort();
		

	}

}
