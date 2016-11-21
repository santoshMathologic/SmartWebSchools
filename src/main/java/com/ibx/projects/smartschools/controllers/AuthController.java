/**
 * 
 */
package com.ibx.projects.smartschools.controllers;


import java.nio.charset.Charset;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gargoylesoftware.htmlunit.javascript.host.Console;
import com.ibx.projects.smartschools.models.Class_table;
import com.ibx.projects.smartschools.models.User;
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
	}
@RequestMapping(value="/getLoginInfoClass",method = RequestMethod.GET)
	public @ResponseBody String getLoginInfoClass(){
		  return "Call the Url to get the Login Information!!!!!!!!!";
	}
	
	@RequestMapping(value="/doLogin",method = RequestMethod.POST)
	public String doLogin(HttpServletRequest httpRequest){
		
		final String authorization = httpRequest.getHeader("Authorization");
	    if (authorization != null && authorization.startsWith("Basic")) {

	        String base64Credentials = authorization.substring("Basic".length()).trim();
	        String credentials = new String(Base64.getDecoder().decode(base64Credentials),
	                Charset.forName("UTF-8"));
	        // credentials = username:password
	        final String[] userCredentials= credentials.split(":",2);
	        
	           System.out.println(""+userCredentials[0]);
	           System.out.println(""+userCredentials[1]);
	        
	    }

		
	 
		return "class created Successfully";
	}
	
	
	

}
