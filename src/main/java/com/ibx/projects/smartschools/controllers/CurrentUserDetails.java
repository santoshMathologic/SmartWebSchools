/**
 * 
 */
/**
 * @author SANTOSH
 *
 */
package com.ibx.projects.smartschools.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ibx.projects.smartschools.models.Role;
import com.ibx.projects.smartschools.models.User;
import com.ibx.projects.smartschools.repositories.RoleRepository;
import com.ibx.projects.smartschools.repositories.UserRepository;



@RestController
@RequestMapping("/api/custom/user")
public class CurrentUserDetails {
	 @Autowired
	 UserRepository userRepository;
	 @Autowired
	 RoleRepository roleRepository;
	 final PageRequest page1 = new PageRequest(
			  0, 5, Direction.ASC, "employeeNo"
			);
	 
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
		 userdetails.setMarkDelete(false);
		 userdetails.setAddress("Bangalore");
		 userdetails.setRole(roleRepository.findOne(Long.valueOf(1)));
		 userRepository.save(userdetails);
		 
		
		 return "User Created SuccessFully";
		 
	 }
	
	 
	 @RequestMapping(value="/UserDetails", method= RequestMethod.GET)
	    public @ResponseBody String UserDetails() {
		 
		 List<User> users =  userRepository.findAll();
		// List<User> videos = Gson.fromJson(users, new TypeToken<List<User>>(){}.getType());
		 GsonBuilder gsonBuilder = new GsonBuilder();
		    Gson gson = gsonBuilder.registerTypeAdapter(Role.class, new RoleAdapter()).create();
		    return gson.toJson(users);
		 
		 
		
		// return users;
	 }
	 
	 @RequestMapping(value="/createUser",method  = RequestMethod.POST)
		public String createUser(@RequestBody User user){
			
			if(user!=null){
				user.setMarkDelete(false);
				user.setRole(roleRepository.findOne(3L));
				userRepository.save(user);	
			}
	
			return "User has been Created Successfully";
			
		}
	
	

}

    