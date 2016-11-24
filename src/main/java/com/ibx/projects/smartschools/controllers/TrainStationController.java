
package com.ibx.projects.smartschools.controllers;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibx.projects.smartschools.models.TrainStation;
import com.ibx.projects.smartschools.repositories.TrainStationRepository;

/**
 * @author SANTOSH
 *
 */
@RestController
@RequestMapping("/api/v1/trainStation")
public class TrainStationController {

	/**
	 * 
	 */
	
	@Autowired
	TrainStationRepository trainStationRepository;
	
	public TrainStationController() {
	}
	
	@RequestMapping(value="/getStationInfo",method = RequestMethod.GET)
	public @ResponseBody String provideStationInfo(){
		return "to get the Train station information please fetch the URl";
 

        }
	
	@RequestMapping(value="/getStationList",method = RequestMethod.GET)
	public @ResponseBody Page<TrainStation> getAllStation(
			@PathParam("orderBy") String orderBy,
			@PathParam("limit") int limit,
			@PathParam("perPage")int perPage
			){
		
		//perPage = (perPage!=0) ? perPage:10;
		PageRequest page1 = new PageRequest(perPage,limit, Direction.ASC, orderBy);
		Page<TrainStation>trainStationList  = trainStationRepository.findAll(page1);
		  return trainStationList;
		

        }

}
