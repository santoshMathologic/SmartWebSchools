/**
 * 
 */
package com.ibx.projects.smartschools.controllers;


import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibx.projects.smartschools.models.Class_table;
import com.ibx.projects.smartschools.repositories.ClassRepository;
import com.ibx.projects.smartschools.repositories.LoginRepository;



/**
 * @author SANTOSH
 *
 */
@RestController
@RequestMapping("login")
public class AuthController {


	@Autowired
	LoginRepository loginRepository;
	
	

	
	public AuthController() {
		// TODO Auto-generated constructor stub
	}
@RequestMapping(value="/getLoginInfoClass",method = RequestMethod.GET)
	public @ResponseBody String getLoginInfoClass(){
		  return "Call the Url to get the Login Information!!!!!!!!!";
	}
	
	@RequestMapping(value="/doLogin",method = RequestMethod.POST)
	public String doLogin(@PathParam("username")String username,@PathParam("password")String password ){
		
	 
		return "class created Successfully"+username+" "+password;
	}
	
	
	

}
