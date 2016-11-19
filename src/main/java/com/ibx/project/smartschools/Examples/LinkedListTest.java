/**
 * 
 */
package com.ibx.project.smartschools.Examples;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author SANTOSH
 *
 */
public class LinkedListTest {

	
	public LinkedListTest() {
		// TODO Auto-generated constructor stub
	}
	
	public void checkLinkList1(LinkedList<Integer> r){
		System.out.print ("Check Link List Method 1 :"); 
		for(int n =0;n<r.size();n++)
		{
                  System.out.print (" "+r.get(n));			
		}
		
	}
	
public void checkLinkList2(LinkedList<Integer> r){
	
	Iterator<Integer> it = r.iterator();
	System.out.print ("Check Link List Method 2 :");
	while(it.hasNext()){
		System.out.print(" "+it.next());
	}
		
	}

public void checkLinkList3(LinkedList<Integer> r){
	System.out.print ("Check Link List Method 3 :");
	 for(int n:r){
		 System.out.print(" "+n);
	 }
	
}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		LinkedListTest linkedListTest = new LinkedListTest();
		
		LinkedList<Integer> r =  new LinkedList<>();
		r.add(10);
		r.add(80);
		r.add(90);
		r.add(100);
		linkedListTest.checkLinkList1(r);
		System.out.println();
		linkedListTest.checkLinkList2(r);
		
		System.out.println();
		linkedListTest.checkLinkList3(r);
		

	}

}
