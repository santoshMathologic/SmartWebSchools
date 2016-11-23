/**
 * 
 */
package com.ibx.projects.smartschools.controllers;

import javax.websocket.server.PathParam;

import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibx.projects.smartschools.models.UserPlan;
import com.ibx.projects.smartschools.repositories.UserPlanRepository;
import com.ibx.projects.smartschools.repositories.UserRepository;

/**
 * @author SANTOSH
 *
 */

@RestController
@RequestMapping("/api/v1/userPlan")
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
			userplan.setPlanName(userplan.getPlanName());
			userplan.setUser(userRepository.findOne(1L));
			userplanRepository.save(userplan);
			
			
		}
		return "plan Created Successfully";
	}
	
	@RequestMapping(value="/updatePlan",method  = RequestMethod.PUT)
	public String updatePlan(@PathParam("id") Long id,@RequestBody UserPlan userplan){
		
		if(userplan!=null){
			UserPlan plan  =  userplanRepository.findOne(id);
			plan.setPlanName(userplan.getPlanName());
			userplanRepository.save(plan);
			
			
		}
		return "Updated Plan Successfully";
	}
	@RequestMapping(value="/removePlan",method  = RequestMethod.DELETE)
	public String removePlan(@PathParam("id") Long id){
		
		
			if(id!=null){
				userplanRepository.delete(id);	
			}
			
			
		
		return "deleted Plan Successfully";
	}
	
	@RequestMapping(value="/getUserPlan",method = RequestMethod.GET)
	public @ResponseBody Page<UserPlan> getUserPlan(
			@PathParam("ordeBy") String ordeBy,
			@PathParam("limit") int limit,
			@PathParam("perPage")int perPage
			){
		
		PageRequest page1 = new PageRequest(perPage,limit, Direction.ASC, ordeBy);
		Page<UserPlan>userPlanList  = userplanRepository.findAll(page1);
		 
		  return userPlanList;
		
		  
	}

}
