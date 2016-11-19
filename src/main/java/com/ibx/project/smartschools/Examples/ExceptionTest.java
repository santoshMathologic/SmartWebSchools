/**
 * 
 */
package com.ibx.project.smartschools.Examples;

import java.io.IOException;

/**
 * @author SANTOSH
 *
 */
public class ExceptionTest {

	/**
	 * 
	 */
	public ExceptionTest() {
		// TODO Auto-generated constructor stub
	}

	
	public int check(){
		
		 try{
			 throw new IOException("IoException ");
			// return 1;
		 }catch(Exception e){
			 System.out.println("catch Block"+e);
		 }finally{
			 System.out.println("Finally Return");
		 }
		
		 return 0;
	}
	
	public static void main(String[] args) {
		
		ExceptionTest et= new ExceptionTest();
		int n = et.check();
		System.out.println(""+n);
		

	}

}
