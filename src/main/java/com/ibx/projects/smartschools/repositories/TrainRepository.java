/**
 * 
 */
package com.ibx.projects.smartschools.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ibx.projects.smartschools.models.Day;
import com.ibx.projects.smartschools.models.Train;




/**
 * @author SANTOSH
 *
 */
@RepositoryRestResource
public interface TrainRepository extends JpaRepository<Train, Long> {
	
	  
	  
	  @Query("Select t from Train as t where ( t.trainNo = :trainNo ) ")
	  List<Train> findByTrainNumber(@Param("trainNo")Integer trainNo);
	  
	  Train findByTrainNoAndStartDay(@Param("trainNo") Integer trainNo, @Param("startDay") Day startDay);
	

}
