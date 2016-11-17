/**
 * 
 */
package com.ibx.projects.smartschools.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ibx.projects.smartschools.models.Class_table;
import com.ibx.projects.smartschools.models.Role;
import com.ibx.projects.smartschools.models.Station;
import com.ibx.projects.smartschools.models.User;
import java.lang.String;
import java.util.List;



/**
 * @author SANTOSH
 *
 */
@RepositoryRestResource
public interface StationRepository extends JpaRepository<Station, Long> {

	Page<Station> findAll(Pageable pageable);
	Station  findByCode(@Param("code")String code);

}
