package com.ibx.projects.smartschools.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibx.projects.smartschools.models.Role;
import com.ibx.projects.smartschools.models.User;
import com.ibx.projects.smartschools.repositories.RoleRepository;
import com.ibx.projects.smartschools.repositories.UserRepository;

@RestController
@RequestMapping("api/role")
public class RoleController {

	@Autowired
	RoleRepository roleRepository;
	UserRepository userRepository;
	public RoleController() {
		
	}
	
	@RequestMapping(value="/createRole",method  = RequestMethod.POST)
	public String createRole(@RequestBody Role role){
		
		//User userObject  = userRepository.findOne(Long.valueOf(1));
		if(role!=null){
			roleRepository.save(role);	
		}
		
		
		
		
		return "Role Created Successfully";
		
	}

}
