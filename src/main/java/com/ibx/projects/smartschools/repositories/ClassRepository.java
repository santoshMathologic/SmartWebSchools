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
import com.ibx.projects.smartschools.models.User;



/**
 * @author SANTOSH
 *
 */
@RepositoryRestResource
public interface ClassRepository extends JpaRepository<Class_table, Long> {

	Page<Class_table> findAll(Pageable pageable);
	
	@Query("Select t from Class_table as t where ( t.className LIKE %:className% or :className is '%%' or :className is null ) AND "
			+ "( t.section_1 LIKE %:section_1% or :section_1 is '%%' or :section_1 is null ) AND "
			+ "( t.section_2 LIKE %:section_2% or :section_2 is '%%' or :section_2 is null ) AND "
			+ "( t.section_3 LIKE %:section_3% or :section_3 is '%%' or :section_3 is null ) AND "
			+ "( t.section_4 LIKE %:section_4% or :section_4 is '%%' or :section_4 is null ) AND "
			+ "( t.section_5 LIKE %:section_5% or :section_5 is '%%' or :section_5 is null ) AND "
			+ "( t.section_6 LIKE %:section_6% or :section_6 is '%%' or :section_6 is null ) AND "
			+ "( t.section_7 LIKE %:section_7% or :section_7 is '%%' or :section_7 is null ) AND "
			+ "( t.section_8 LIKE %:section_8% or :section_8 is '%%' or :section_8 is null ) AND "
			+ "( t.section_9 LIKE %:section_9% or :section_9 is '%%' or :section_9 is null ) AND "
			+ "( t.section_10 LIKE %:section_10% or :section_10 is '%%' or :section_10 is null ) ")
	Page<Class_table> findByAllParams(
			@Param("section_1") String section_1,
			@Param("section_2") String section_2,
			@Param("section_3") String section_3,
			@Param("section_4") String section_4,
			@Param("section_5") String section_5,
			@Param("section_6") String section_6,
			@Param("section_7") String section_7,
			@Param("section_8") String section_8,
			@Param("section_9") String section_9,
			@Param("section_10") String section_10, Pageable pageable);

}
