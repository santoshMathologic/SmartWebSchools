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
	 
	 @Query("Select cst from Class_subject_table as cst where ( cst.subject1 LIKE %:s1% or :s1 is '%%' or :s1 is null ) AND "
				+ "( cst.subject2 LIKE %:s2% or :s2 is '%%' or :s2 is null ) AND "
				+ "( cst.subject3 LIKE %:s3% or :s3 is '%%' or :s3 is null ) AND "
				+ "( cst.subject4 LIKE %:s4% or :s4 is '%%' or :s4 is null ) AND "
				+ "( cst.subject5 LIKE %:s5% or :s5 is '%%' or :s5 is null ) AND "
				+ "( cst.subject6 LIKE %:s6% or :s6 is '%%' or :s6 is null ) AND "
				+ "( cst.subject7 LIKE %:s7% or :s7 is '%%' or :s7 is null ) AND "
				+ "( cst.subject8 LIKE %:s8% or :s8 is '%%' or :s8 is null ) AND "
				+ "( cst.subject9 LIKE %:s9% or :s9 is '%%' or :s9 is null ) AND "
				+ "( cst.subject10 LIKE %:s10% or :s10 is '%%' or :s10 is null ) ")
		Page<Class_subject_table> findByAllParams(
				@Param("s1") String  s1,
				@Param("s2") String  s2,
				@Param("s3") String  s3,
				@Param("s4") String  s4,
				@Param("s5") String  s5,
				@Param("s6") String  s6,
				@Param("s7") String  s7,
				@Param("s8") String  s8,
				@Param("s9") String  s9,
				@Param("s10") String s10,Pageable pageable);
     
	 Optional<Class_subject_table> findBysubject1(String subjectName);
	 
	Page<Class_subject_table> findAll(Pageable pageable);

}
