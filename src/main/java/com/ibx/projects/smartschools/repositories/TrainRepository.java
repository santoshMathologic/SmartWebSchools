/**
 * 
 */
package com.ibx.projects.smartschools.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ibx.projects.smartschools.models.Train;



/**
 * @author SANTOSH
 *
 */
@RepositoryRestResource
public interface TrainRepository extends JpaRepository<Train, Long> {

	

}
