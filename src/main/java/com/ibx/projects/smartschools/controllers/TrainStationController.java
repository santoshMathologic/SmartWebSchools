
package com.ibx.projects.smartschools.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
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
	
	 @Autowired
	 private SessionFactory sessionFactory;
	
	public TrainStationController() {
	}
	
	@RequestMapping(value="/getStationInfo",method = RequestMethod.GET)
	public @ResponseBody String provideStationInfo(){
		return "to get the Train station information please fetch the URl";
 

        }
	
	@RequestMapping(value="/getStationLists",method = RequestMethod.GET)
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
	
	@RequestMapping(value="/getStationList",method = RequestMethod.GET)
	public @ResponseBody List<TrainStation> getStation_by_trainNo_and_startDay(
			@PathParam("limit") int limit,
			@PathParam("perPage")int perPage,
			@PathParam("trainNumber")int trainNumber
			){
		
		String sql ="SELECT train_station.id,"
				+ "train_station.departure_time,"
				+ "station.code,train.train_no,"
				+ "train.train_name,"
				+ "train_station.arrival_time,"
				+ "train_station.stop_number,"
				+ "station.name "
				+ "FROM `train_station`"
				+ "JOIN `train` ON train_station.train_id = train.`id` "
				+ "JOIN `station` "
				+ "ON station.`id`= train_station.`station_id` "
				+ "WHERE  train.`train_no` = :trainNumber ORDER BY  train_station.`stop_number` ASC LIMIT :limit OFFSET :perPage";
		Session s = sessionFactory.openSession(); 
		Query query = s.createSQLQuery(sql);
		//Long countResults = (Long) query.uniqueResult();
		//int lastPageNumber = (int) ((countResults / limit) + 1);
		//query.setFirstResult((lastPageNumber - 1) * limit);
		//query.setMaxResults(limit);
		query.setParameter("trainNumber",trainNumber);
		query.setParameter("perPage",perPage);
		query.setParameter("limit",limit);
		
		
		
		        
		
		List<TrainStation> results = query.list();
		System.out.println(results);
		
		List<Object[]> rows = query.list();
		List<TrainStation> TrainStationList = new ArrayList<TrainStation>();
		
		TrainStation ts= null;
		Station st = null;
		Train t =  null;
		for(Object[] row : rows){
			ts= new TrainStation();
			st = new Station();
			t =  new Train();
			
			ts.setId(Long.parseLong(row[0].toString()));
			ts.setDepartureTime(row[1].toString());
			st.setCode(row[2].toString());
			t.setTrainNo(Integer.parseInt(row[3].toString()));
			t.setTrainName(row[4].toString());
			ts.setArrivalTime(row[5].toString());
			ts.setStopNumber(Integer.parseInt(row[6].toString()));
			st.setName(row[7].toString());
			ts.setTrain(t);
			ts.setStation(st);
			
			
			TrainStationList.add(ts);
		}
		 return TrainStationList;
		

        }

}
