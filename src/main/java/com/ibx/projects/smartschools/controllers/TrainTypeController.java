/**
 * 
 */
package com.ibx.projects.smartschools.controllers;

import javax.websocket.server.PathParam;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibx.projects.smartschools.models.TrainType;
import com.ibx.projects.smartschools.repositories.TrainTypeRepository;

/**
 * @author SANTOSH
 *
 */
@RestController
@RequestMapping("/api/v1/trainType")
public class TrainTypeController {

	/**
	 * 
	 */
	@Autowired
	TrainTypeRepository trainTypeRepository;
	
	@Autowired
	private SessionFactory sessionFactory;
	public TrainTypeController() {
		
	}
	@RequestMapping(value="/getTrainTypeList",method = RequestMethod.GET)
	public @ResponseBody Page<TrainType> getTrainTypeList(
			@PathParam("ordeBy") String ordeBy,
			@PathParam("limit") int limit,
			@PathParam("perPage")int perPage
			){
		
		PageRequest page1 = new PageRequest(perPage,limit, Direction.ASC, ordeBy);
		Page<TrainType>trainTypeList  = trainTypeRepository.findAll(page1);
		  return trainTypeList;
		
		  
	}
	
	
}
