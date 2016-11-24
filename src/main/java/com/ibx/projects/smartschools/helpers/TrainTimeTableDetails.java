/**
 * 
 */
package com.ibx.projects.smartschools.helpers;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibx.project.smartschools.utils.TimeCalculator;
import com.ibx.projects.smartschools.models.Station;
import com.ibx.projects.smartschools.models.Train;
import com.ibx.projects.smartschools.models.TrainStation;
import com.ibx.projects.smartschools.repositories.StationRepository;
import com.ibx.projects.smartschools.repositories.TrainRepository;
import com.ibx.projects.smartschools.repositories.TrainStationRepository;

/**
 * @author SANTOSH
 *
 */
@Service("TrainTimeTableDetails")
public class TrainTimeTableDetails implements CSVtoDataBase {

	/**
	 * 
	 */
	
	@Autowired
	StationRepository stationRepository; 
	
	@Autowired
	TrainStationRepository trainStationRepository;
	
	@Autowired
	TrainRepository trainRepository;
	
	
	
	public TrainTimeTableDetails() {
	}

	
	@Override
	public boolean processRecordToTable(String[] columns) {
		Station station = null;
		TrainStation trainStation = null;
	    Integer trainNo =   Integer.parseInt(columns[0]);
	    int arrivalday = 0;
	    int departureDay = 0;
		           
		          
		           if(station==null){
		        	   station = new Station();
		        	   station  =  stationRepository.findByCode(columns[2]);
		           }
		           
		           List<Train> trainList  = trainRepository.findByTrainNumber(trainNo);
		           
		            for(Train train:trainList){
		            	trainStation = new TrainStation();
		            	trainStation.setStation(station);
		            	trainStation.setTrain(train);
		            	trainStation.setDayOfJourney(Integer.parseInt(columns[3]));
		            	trainStation.setArrivalTime(columns[4]);
		            	trainStation.setDepartureTime(columns[5]);
						trainStation.setDistance(Long.parseLong(columns[6]));
						trainStation.setStopNumber(Integer.parseInt(columns[1]));
					 	trainStation.setArrivalMinutes(TimeCalculator.hoursToMinutes(trainStation.getArrivalTime()));
					 	trainStation.setDepartureMinutes(TimeCalculator.hoursToMinutes(trainStation.getDepartureTime()));
					 	
					 	if(trainStation.getDayOfJourney()!=null){
					 		arrivalday =  trainStation.getDayOfJourney()-1;
					 		trainStation.setArrivalDay(arrivalday);	
					 	}
					 	
					 	
					 	
					 	if (trainStation.getArrivalMinutes() > trainStation.getDepartureMinutes()) {
				            departureDay = arrivalday+ 1;
				            trainStation.setDepartureDay(departureDay);
				            
				        }
				        else {
				            departureDay = arrivalday;
				            trainStation.setDepartureDay(departureDay);
				        }
					 	
					 	
						
						if (trainStation.getDistance()>0) {
							
							
							
							       
						}
		            	
		            	trainStationRepository.save(trainStation);
		            	
		            }
		
		           
		 
		 
		
		return false;
	}

}
