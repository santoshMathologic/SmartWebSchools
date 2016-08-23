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
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ibx.projects.smartschools.models.Class_subject_table;

/**
 * @author SANTOSH
 *
 */
@RepositoryRestResource
public interface ClassSubjectRepository extends JpaRepository<Class_subject_table, Long>{
	
	
	 @Query("SELECT t.subject1,t.subject2,t.subject1 FROM Class_subject_table t where t.id = :id") 
	 Page<Class_subject_table> findSubjectById(@Param("id") Long id, Pageable pagable);
	 
	Page<Class_subject_table> findAll(Pageable pageable);

}
