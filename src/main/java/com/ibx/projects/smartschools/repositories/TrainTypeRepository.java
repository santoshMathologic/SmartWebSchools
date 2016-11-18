/**
 * 
 */
package com.ibx.projects.smartschools.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ibx.projects.smartschools.models.TrainType;
import java.lang.String;



/**
 * @author SANTOSH
 *
 */
@RepositoryRestResource
public interface TrainTypeRepository extends JpaRepository<TrainType, Long> {

 TrainType findByName(@Param("TraintypeName")String TraintypeName);

}
