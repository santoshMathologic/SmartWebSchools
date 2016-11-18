/**
 * 
 */
package com.ibx.projects.smartschools.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibx.projects.smartschools.models.Station;
import com.ibx.projects.smartschools.models.Train;
import com.ibx.projects.smartschools.repositories.TrainRepository;

/**
 * @author SANTOSH
 *
 */
@RestController
@RequestMapping("/api/v1/train")
public class TrainController {

	/**
	 * 
	 */
	@Autowired
	TrainRepository trainRepository;
	
	@Autowired
	private SessionFactory sessionFactory;
	public TrainController() {
		// TODO Auto-generated constructor stub
	}
	@RequestMapping(value="/getTrainList",method = RequestMethod.GET)
	public @ResponseBody Page<Train> getTrainList(
			@PathParam("ordeBy") String ordeBy,
			@PathParam("limit") int limit,
			@PathParam("perPage")int perPage
			){
		
		PageRequest page1 = new PageRequest(perPage,limit, Direction.ASC, ordeBy);
		Page<Train>trainList  = trainRepository.findAll(page1);
		  return trainList;
		
		  
	}
	
	@RequestMapping(value="/getStationsList",method = RequestMethod.GET)
	public @ResponseBody String getStationsList(
			@PathParam("ordeBy") String ordeBy,
			@PathParam("limit") int limit,
			@PathParam("perPage")int perPage
			){
		

		
		Query q = sessionFactory.openSession().createQuery(" FROM Station ");
		q.setFirstResult(perPage);
		q.setMaxResults(limit);
		List<Station>stationList  = q.list();
		
		
		
		return "The Size of Station"+stationList.size();
		
	
		
		  
	}

}