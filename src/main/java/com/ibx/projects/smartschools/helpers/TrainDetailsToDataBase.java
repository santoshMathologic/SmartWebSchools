/**
 * 
 */
package com.ibx.projects.smartschools.helpers;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibx.projects.smartschools.models.Day;
import com.ibx.projects.smartschools.models.Station;
import com.ibx.projects.smartschools.models.Train;
import com.ibx.projects.smartschools.models.TrainType;
import com.ibx.projects.smartschools.repositories.StationRepository;
import com.ibx.projects.smartschools.repositories.TrainRepository;
import com.ibx.projects.smartschools.repositories.TrainTypeRepository;

/**
 * @author SANTOSH
 *
 */

@Service("TrainDetails")
public class TrainDetailsToDataBase implements CSVtoDataBase {

	/**
	 * 
	 */
	
	@Autowired
	TrainRepository trainRepository;
	
	
	 @Autowired
	 StationRepository stationRepository;
	 
	 @Autowired
	 TrainTypeRepository trainTypeRepository;
	 
	 
	 
	
	
	public TrainDetailsToDataBase() {
	}

	@Override
	public boolean processRecordToTable(String[] columns) {
		
		
		Station fromStation = null;
		Station toStation = null;
		TrainType trainType  = null;
		Train train = null;
		
		
		try {
			if (fromStation == null) {
				fromStation = new Station();
				fromStation = stationRepository.findByCode(columns[2]);
			}
			if (toStation == null) {
				toStation = new Station();
				toStation = stationRepository.findByCode(columns[3]);
			}
			if (trainType == null) {
				trainType = new TrainType();
				trainType = trainTypeRepository.findByName(columns[11]);
			}
			try {
				final int fixday = 4;
				List<Train> trains = new LinkedList<Train>();
				for (int i = 4; i <=10; i++) {
					if (!columns[i].isEmpty() && columns[i].contains("y")) {
						Integer trainNo = Integer.parseInt(columns[0]);
						Day startDay = Day.values()[i-fixday];
						train = new Train();
						train.setTrainNo(trainNo);
						train.setStartDay(startDay);
						train.setTrainName(columns[1]);
						train.setFromStation(fromStation);
						train.setToStation(toStation);
						train.setTrainType(trainType);
						trains.add(train);
					}
				}
				trainRepository.save(trains);
			

		} catch (Exception e) {
			 System.out.println(e.getMessage());
		}
    }catch(Exception e){
    	System.out.println(""+e);
    }
		return false;
 }
}


