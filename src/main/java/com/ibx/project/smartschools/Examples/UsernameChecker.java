/**


Sample Input

4
alpha_naheed
xahidbuffon
nagib@007
123Swakkhar


Sample Output

Valid
Valid
Invalid
Invalid
Explanation

The first two cases fulfill the constraints of a valid username. The third case is invalid because it contains an invalid character '@'. The fourth case is also invalid because it starts with a numeric character.

 * 
 */
package com.ibx.project.smartschools.Examples;

import java.util.Scanner;

/**
 * @author SANTOSH
 *
 */
public class UsernameChecker {

	/**
	 * 
	 */
	public UsernameChecker() {
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
		  System.out.println("Enter  No of UserName");
	      int noOfLines = Integer.parseInt(in.nextLine());
	      while(noOfLines>0 && noOfLines <100 ){
	         String username = in.nextLine();
	         System.out.println(""+username);
	         
	      }

	}

}
