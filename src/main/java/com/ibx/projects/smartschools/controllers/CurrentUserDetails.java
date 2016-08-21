/**
 * 
 */
/**
 * @author SANTOSH
 *
 */
package com.ibx.projects.smartschools.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibx.projects.smartschools.models.User;
import com.ibx.projects.smartschools.repositories.RoleRepository;
import com.ibx.projects.smartschools.repositories.UserRepository;



@RestController
@RequestMapping("/api/custom/user")
public class CurrentUserDetails {
	 @Autowired
	 UserRepository userRepository;
	 RoleRepository roleRepository;
	 
	 @RequestMapping(value="/myDetails", method= RequestMethod.POST)
	    public String  myDetails() {
		 
		 User userdetails = new User();
		 userdetails.setUsername("SANTOSH_USER");
		 userdetails.setEmployeeNo("1012");
		 userdetails.setEmail("santosh.citech@gmail.com");
		 userdetails.setFirstName("santosh");
		 userdetails.setLastName("SAHU");
		 userdetails.setMobileNo("9008365317");
		 userdetails.setPassword("SANTOSH123456");
		 userdetails.setTelephoneNo("456-51258-5262");
		 userdetails.setRole(roleRepository.findOne(Long.valueOf(1)));
		 userRepository.save(userdetails);
		 
		
		 return "User Created SuccessFully";
		 
	 }
	
	

}
    