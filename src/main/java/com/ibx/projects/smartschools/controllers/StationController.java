/**
 * 
 */
/**
 * @author SANTOSH
 *
 */
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

import com.ibx.projects.smartschools.models.Station;
import com.ibx.projects.smartschools.repositories.StationRepository;



@RestController
@RequestMapping("/api/v1/station")
public class StationController {
	 @Autowired
	 StationRepository stationRepository;
	
	 final PageRequest page1 = new PageRequest(
			  0, 5, Direction.ASC, "name"
			);
	 
	
	
	 
	 @RequestMapping(value="/getStation", method= RequestMethod.GET)
	    public @ResponseBody Page<Station> UserDetails(
	    		@PathParam("ordeBy") String ordeBy,
				@PathParam("limit") int limit,
				@PathParam("page")int page
				){
			
			
			Page<Station>stationList  = stationRepository.findAll(new PageRequest(page,limit, Direction.ASC,ordeBy));
			  return stationList; 
      	 }
	 
	
	
	

}

    