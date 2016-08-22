/**
 * 
 */
package com.ibx.projects.smartschools.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ibx.projects.smartschools.models.Class_subject_table;

/**
 * @author SANTOSH
 *
 */
@RepositoryRestResource
public interface ClassSubjectRepository extends JpaRepository<Class_subject_table, Long>{
	
	Page<Class_subject_table> findAll(Pageable pageable);

}
