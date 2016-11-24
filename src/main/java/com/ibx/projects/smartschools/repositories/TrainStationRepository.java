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
			+ "( ts.train.trainNo = :trainNo)")
	Page<TrainStation> findByTrainNoAndStartDay(@Param("trainNo")Integer trainNo,Pageable pageable);
	
	

}
