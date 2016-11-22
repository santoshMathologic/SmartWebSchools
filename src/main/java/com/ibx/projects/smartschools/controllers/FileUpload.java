/**
 * 
 */
package com.ibx.projects.smartschools.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ibx.projects.smartschools.models.Day;
import com.ibx.projects.smartschools.models.Station;
import com.ibx.projects.smartschools.models.Train;
import com.ibx.projects.smartschools.models.TrainStation;
import com.ibx.projects.smartschools.repositories.StationRepository;
import com.ibx.projects.smartschools.repositories.TrainRepository;
import com.ibx.projects.smartschools.repositories.TrainStationRepository;
import com.ibx.projects.smartschools.repositories.TrainTypeRepository;
import com.opencsv.CSVReader;

/**
 * @author SANTOSH
 *
 */
@Controller
public class FileUpload {

	/**
	 * 
	 */
	@Autowired
	TrainRepository trainRepository;
	
	@PersistenceContext
	private EntityManager entityManager;

	private Train trainObject;
	
	 @Autowired
	 StationRepository stationRepository;
	 
	 @Autowired
	 TrainTypeRepository trainTypeRepository;
	 
	 @Autowired
	 TrainStationRepository trainStationRepository;
	 
	public FileUpload() {
		
		
	}
	@RequestMapping(value="/upload", method= RequestMethod.GET)
    public @ResponseBody String provideUploadInfo() {
        return "You can upload a file by posting to this same URL.";
    }
	 @RequestMapping(value="/uploadTrainDetails",headers=("content-type=multipart/*"),method=RequestMethod.POST)
	    public @ResponseBody String handleUploadTrainDetails(@RequestParam("file") MultipartFile fileTrainDetails,HttpServletRequest request) throws IOException{
	   
		 	Path currentRelativePath = Paths.get("");
		   	String s = currentRelativePath.toAbsolutePath().toString();
		   	String nameTrainDetails = s+"/uploads";
		   	
		   	Integer trainNo = null;
			String startDays=new String();
			String trainName = null;
			Integer day=new Integer(0);
			String fromStationCode = null;
    		String toStationCode = null;
    		String trainType = null;
    		Day days = null;
		     
		    
		     if (!fileTrainDetails.isEmpty()) {
		         try {
		        	 // writes to the buffer contents of the csv file
		        	 File file = new File(nameTrainDetails);
		        	 file.mkdirs();
		        	 nameTrainDetails += "/"+fileTrainDetails.getOriginalFilename();
		        	 nameTrainDetails = nameTrainDetails.replace("%20", " ");
		        	 nameTrainDetails = nameTrainDetails.replace("\\", "/");
		        	 file =  new File(nameTrainDetails);
		             byte[] bytes = fileTrainDetails.getBytes();
		             BufferedOutputStream stream =
		                     new BufferedOutputStream(new FileOutputStream(file));
		             stream.write(bytes);
		             stream.close();

		             if(!fileTrainDetails.getOriginalFilename().contains(".csv")){
		                 return "Uploaded file is not CSV";
		             }

		            List<Train> trainLists = new ArrayList<>();
		             CSVReader reader = new CSVReader(new FileReader(nameTrainDetails),',','\'',1);
		             for (String[] columns; (columns = reader.readNext()) != null;) {
		            	 
		            	    trainObject  = new Train();
		            	
		            		trainNo 			= Integer.parseInt(columns[0]);
		            		trainName 			= columns[1];
		            		fromStationCode 	= columns[2];
		            		toStationCode 		= columns[3];
		            		trainType 			= columns[11];
		            		
		            		trainObject.setTrainNo(trainNo);
		            		trainObject.setTrainName(trainName);
		            	
		            		trainObject.setStartDay(days.MONDAY);
		            		trainObject.setFromStation(stationRepository.findByCode(fromStationCode));
		            		trainObject.setToStation(stationRepository.findByCode(toStationCode));
		            		trainObject.setTrainType(trainTypeRepository.findByName(trainType));
		            		
		            		trainLists.add(trainObject);
		            	    trainRepository.save(trainLists);
		             }

		            
		             return "You successfully uploaded " + nameTrainDetails + "!";
		         } catch (Exception e) {
		             return "You failed to upload " + nameTrainDetails + " => " + e.getMessage();
		         }
		     } else {
		         return "You failed to upload " + nameTrainDetails + " because the file was empty.";
		     }
		    	
	 }
	 
	@RequestMapping(value = "/uploadTrainTimeTable", headers = ("content-type=multipart/*"), method = RequestMethod.POST)
	public @ResponseBody String uploadTrainTimeTable(@RequestParam("file") MultipartFile fileTrainStationDetails,
			HttpServletRequest request) throws IOException {

		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		String nameTrainDetails = s + "/uploads";

		Integer trainNo = null;

		String stationCode = null;
		Integer dayofJourney = new Integer(0);
		Integer distance = new Integer(0);
		Integer stopNumber = new Integer(0);
		String arrival_time = new String();

		String departure_time = new String();
		List<TrainStation> trainStationLists = new ArrayList<TrainStation>();

		TrainStation trainStation = null;
		Day days = null;

		Station station = null;

		if (!fileTrainStationDetails.isEmpty()) {
			try {
				// writes to the buffer contents of the csv file
				File file = new File(nameTrainDetails);
				file.mkdirs();
				nameTrainDetails += "/" + fileTrainStationDetails.getOriginalFilename();
				nameTrainDetails = nameTrainDetails.replace("%20", " ");
				nameTrainDetails = nameTrainDetails.replace("\\", "/");
				file = new File(nameTrainDetails);
				byte[] bytes = fileTrainStationDetails.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(file));
				stream.write(bytes);
				stream.close();

				if (!fileTrainStationDetails.getOriginalFilename().contains(".csv")) {
					return "Uploaded file is not CSV";
				}

				CSVReader reader = new CSVReader(new FileReader(nameTrainDetails), ',', '\'', 1);
				for (String[] columns; (columns = reader.readNext()) != null;) {

					trainNo = Integer.parseInt(columns[0]);
					stopNumber = Integer.parseInt(columns[1]);
					stationCode = columns[2];
					dayofJourney = Integer.parseInt(columns[3]);
					arrival_time = columns[4];
					departure_time = columns[5];
					distance = Integer.parseInt(columns[6]);

					List<Train> TrainNoList = trainRepository.findByTrainNumber(trainNo);

					try{
					for (Train train : TrainNoList) {

						if (trainStation == null) {
							trainStation = new TrainStation();
							trainStation.setTrain(train);

						}
					}
					} catch (Exception exe) {
						System.out.println("Error : in TrainTimeTable :" + exe.getMessage());
						exe.printStackTrace();
					}

					try {
						station = stationRepository.findByCode(stationCode);
						if (station == null) {
							station = new Station();
							station.setCode(stationCode);
						}

						stationRepository.save(station);
					} catch (Exception exe) {
						System.out.println("Error : in Station : " + exe.getMessage());
					}

					trainStation.setArrivalDay(1);
					trainStation.setDepartureDay(1);
					trainStation.setStation(station);
					trainStation.setDayOfJourney(dayofJourney);
					trainStation.setArrivalTime(arrival_time);
					trainStation.setDepartureTime(departure_time);
					trainStation.setStopNumber(stopNumber);
					trainStation.setDistance(Long.valueOf(distance));
					
					trainStation.setDay(days.FRIDAY);
					trainStation.setJourneyDuration(54L);
					
					trainStationRepository.save(trainStation);

				}

				return "You successfully uploaded Station details " + nameTrainDetails + "!";
			} catch (Exception e) {
				return "You failed to upload " + nameTrainDetails + " => " + e.getMessage();
			}
		} else {
			return "You failed to upload " + nameTrainDetails + " because the file was empty.";
		}

	}

}
