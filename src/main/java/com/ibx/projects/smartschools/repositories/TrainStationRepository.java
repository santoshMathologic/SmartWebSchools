/**
 * 
 */
package com.ibx.projects.smartschools.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ibx.projects.smartschools.models.TrainStation;
import com.ibx.projects.smartschools.models.Day;


/**
 * @author SANTOSH
 *
 */
public interface TrainStationRepository extends JpaRepository<TrainStation, Long> {
	
	TrainStation findTopByTrain_TrainNoAndTrain_StartDayOrderByStopNumberDesc(@Param("TrainNo")Integer trainNo, @Param("StartDay")Day startDay);

	@Query("Select ts from TrainStation as ts where "
			+ "( ts.train.trainNo = :trainNo) ORDER BY ts.stopNumber")
	Page<TrainStation> findByTrainNo(@Param("trainNo")Integer trainNo,Pageable pageable);
	
	//@Query("Select ts.arrivalMinutes,t.trainNo,t.fromStation.code from TrainStation as ts inner join ts.train as t where t.trainNo = :trainNumber")
	//@Query("Select ts.arrivalMinutes,t.trainNo,t.fromStation.code from TrainStation as ts inner join ts.train as t where t.trainNo = :trainNumber")\
	
	//@Query("SELECT ts.stopNumber,t.trainNo FROM TrainStation ts inner join Train t ON ts.train= t.id inner join Station as s ON s.id = ts.station WHERE  t.trainNo = :trainNumber ORDER BY ts.stopNumber ASC")
	
	//Page<TrainStation> findByTrainNo(@Param("trainNumber")Integer trainNumber,Pageable pageable);
}
	
