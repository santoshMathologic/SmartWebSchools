/**
 * 
 */
package com.ibx.projects.smartschools.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibx.projects.smartschools.models.TrainStation;
import com.ibx.projects.smartschools.models.Train;
import java.util.List;


/**
 * @author SANTOSH
 *
 */
public interface TrainStationRepository extends JpaRepository<TrainStation, Long> {
	

}
