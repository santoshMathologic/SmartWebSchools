/**
 * 
 */
package com.ibx.projects.smartschools.controllers;


import java.nio.charset.Charset;
import java.security.Key;
import java.util.Base64;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.ibx.projects.smartschools.models.CustomToken;
import com.ibx.projects.smartschools.models.User;
import com.ibx.projects.smartschools.repositories.LoginRepository;
import com.ibx.projects.smartschools.repositories.UserPlanRepository;
import com.ibx.projects.smartschools.repositories.UserRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.impl.compression.CompressionCodecs;
import io.jsonwebtoken.impl.crypto.MacProvider;



/**
 * @author SANTOSH
 *
 */
@RestController
@RequestMapping("login")
public class AuthController {


	@Autowired
	LoginRepository loginRepository;
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserPlanRepository userPlanRepository;
	
	
	
	

	
	public AuthController() {
	}
@RequestMapping(value="/getLoginInfoClass",method = RequestMethod.GET)
	public @ResponseBody String getLoginInfoClass(){
		  return "Call the Url to get the Login Information!!!!!!!!!";
	}
	

/***
 * 
 * 
 * 
 * @param httpRequest
 * @return  
 *  The Following Methods are Written for JWT BASE AUTHENTICATION IN JAVA 
 *  Dependency in Maven 
 *    <groupId>io.jsonwebtoken</groupId>
      <artifactId>jjwt</artifactId>
      <version>0.6.0</version>
 */
	@RequestMapping(value="/doLogin",method = RequestMethod.POST)
	public String doLogin(HttpServletRequest httpRequest){
		String generatedToken = null;
		
		final String authorization = httpRequest.getHeader("Authorization");
	    if (authorization != null && authorization.startsWith("Basic")) {

	        String base64Credentials = authorization.substring("Basic".length()).trim();
	        String credentials = new String(Base64.getDecoder().decode(base64Credentials),Charset.forName("UTF-8"));
	        // credentials = username:password
	        final String[] userCredentials= credentials.split(":",2);
	        
	           
	          
	        generatedToken =  validateUserInfo(userCredentials[0],userCredentials[1]);
	           
	          
	    }else{
	    	 System.out.println("Invalid Authorization");
	    }

		
	 
		return generatedToken;
	}
	
	
	public String validateUserInfo(String username, String password) {
		
		
		String currentPlan;
		String genertatedToken = null;

		User user = userRepository.findByUsernameAndPassword(username, password);
		if (!(user == null)) {
			//currentPlan = userPlanRepository.findByUser_username(username).getPlanName();
			genertatedToken = generateJWTToken(user.getUsername(), user.getPassword(),user.getRole().getName()/*,currentPlan*/);  // generate JSONWEBBASED TOKEN
			
		} else {
			System.out.println("Role Undefined");
		}
		return genertatedToken;
	}

	public String generateJWTToken(String userName,String password, String roleCode/*, String currentPlan*/){
		
		
		
		 /**
         *   Create a object to stor UserName and password and Convert it to Gson Object
         */
		CustomToken customToken = new CustomToken();
		customToken.setUserName(userName);
	    customToken.setPassword(password);
	    customToken.setRoleCode(roleCode);
	   // customToken.setCurrentPlan(currentPlan);
        
		
		 // System.out.println(new Gson().toJson(authCont));
        
        Key key = MacProvider.generateKey();
        
        /**
         *  Encoding Algorithm using BASE AUTH 
         * 
         */
        String compactJwsToken = Jwts.builder()
     		   				.setSubject(new Gson().toJson(customToken))  
     		   				.compressWith(CompressionCodecs.DEFLATE)                         
     		   				.signWith(SignatureAlgorithm.HS512, key)
     		   				.compact();
        
      
        customToken.setToken(compactJwsToken);
        
        System.out.println(""+compactJwsToken);
        
        try {
     	   System.out.println(""+Jwts.parser().setSigningKey(key).parseClaimsJws(compactJwsToken)); 
     	} catch (SignatureException e) {
     	    //don't trust the JWT!
     	}
     
		return new Gson().toJson(customToken); 
		
	}
	
	
	

}
