/**
 * 
 */
package com.ibx.projects.smartschools.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibx.projects.smartschools.models.UserPlan;
import com.ibx.projects.smartschools.repositories.UserPlanRepository;
import com.ibx.projects.smartschools.repositories.UserRepository;

/**
 * @author SANTOSH
 *
 */

@RestController
@RequestMapping("/api/custom/userPlan")
public class UserPlanController {

	/**
	 * 
	 */
	@Autowired
	UserPlanRepository userplanRepository;
	
	@Autowired
	UserRepository userRepository;
	public UserPlanController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value="/createPlan",method  = RequestMethod.POST)
	public String createPlan(@RequestBody UserPlan userplan){
		
		if(userplan!=null){
			userplan.setCo_planner("SANTOSH");
			//userplan.setCreatedTime(new Date());
			userplan.setIsUnderReviewer(false);
			userplan.setMarkDelete(false);
			userplan.setReviewer("santosh");
			userplan.setPlanName("Plan001");
			userplan.setUser(userRepository.findOne(1L));
			userplanRepository.save(userplan);
			
			
		}
		return "plan Created Successfully";
	}

}
