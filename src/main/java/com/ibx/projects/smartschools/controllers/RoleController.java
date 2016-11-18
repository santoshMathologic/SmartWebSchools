package com.ibx.projects.smartschools.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibx.projects.smartschools.models.Role;
import com.ibx.projects.smartschools.repositories.RoleRepository;

@RestController
@RequestMapping("api/role")
public class RoleController {

	@Autowired
	RoleRepository roleRepository;
	
	 final PageRequest page1 = new PageRequest(0,5, Direction.ASC, "name");
	public RoleRepository getRoleRepository() {
		return roleRepository;
	}

	public PageRequest getPage1() {
		return page1;
	}

	public void setRoleRepository(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

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
	@RequestMapping(value="/getRole",method  = RequestMethod.GET)
	public @ResponseBody Page<Role> getRole(){
		Page<Role> roles= roleRepository.findAll(page1);
		
		 return roles; 
		
	}
}
