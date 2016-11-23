/**
 * 
 */
package com.ibx.projects.smartschools.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.ibx.projects.smartschools.models.TrainStation;
import com.ibx.projects.smartschools.models.Day;
import com.ibx.projects.smartschools.models.Train;
import java.util.List;


/**
 * @author SANTOSH
 *
 */
public interface TrainStationRepository extends JpaRepository<TrainStation, Long> {
	
	TrainStation findTopByTrain_TrainNoAndTrain_StartDayOrderByStopNumberDesc(@Param("TrainNo")Integer trainNo, @Param("StartDay")Day startDay);
	

}
