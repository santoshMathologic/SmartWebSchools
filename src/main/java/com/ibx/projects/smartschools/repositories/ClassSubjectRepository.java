/**
 * 
 */
package com.ibx.projects.smartschools.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ibx.projects.smartschools.models.Class_subject_table;
import java.lang.Long;

/**
 * @author SANTOSH
 *
 */
@RepositoryRestResource
public interface ClassSubjectRepository extends JpaRepository<Class_subject_table, Long>{
	
	
	 @Query("SELECT t.subject1,t.subject2,t.subject1 FROM Class_subject_table t where t.id = :id") 
	 Page<Class_subject_table> findSubjectById(@Param("id") Long id, Pageable pagable);
	 
	// Class_subject_table findByClass_subjects_id(Long class_subjects_id);
     
	 Optional<Class_subject_table> findBysubject1(String subjectName);
	 
	Page<Class_subject_table> findAll(Pageable pageable);

}
