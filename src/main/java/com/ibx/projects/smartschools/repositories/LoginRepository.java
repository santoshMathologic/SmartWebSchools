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
public interface LoginRepository extends JpaRepository<Class_table, Long> {

	Page<Class_table> findAll(Pageable pageable);
	
	@Query("Select t from Class_table as t where ( t.className LIKE %:className% or :className is '%%' or :className is null ) AND "
			+ "( t.section_1 LIKE %:section1% or :section1 is '%%' or :section1 is null ) AND "
			+ "( t.section_2 LIKE %:section2% or :section2 is '%%' or :section2 is null ) AND "
			+ "( t.section_3 LIKE %:section3% or :section3 is '%%' or :section3 is null ) AND "
			+ "( t.section_4 LIKE %:section4% or :section4 is '%%' or :section4 is null ) AND "
			+ "( t.section_5 LIKE %:section5% or :section5 is '%%' or :section5 is null ) AND "
			+ "( t.section_6 LIKE %:section6% or :section6 is '%%' or :section6 is null ) AND "
			+ "( t.section_7 LIKE %:section7% or :section7 is '%%' or :section7 is null ) AND "
			+ "( t.section_8 LIKE %:section8% or :section8 is '%%' or :section8 is null ) AND "
			+ "( t.section_9 LIKE %:section9% or :section9 is '%%' or :section9 is null ) AND "
			+ "( t.section_10 LIKE %:section10% or :section10 is '%%' or :section10 is null ) ")
	Page<Class_table> findByAllParams(
			@Param("className") String className,
			@Param("section1") String section1,
			@Param("section2") String section2,
			@Param("section3") String section3,
			@Param("section4") String section4,
			@Param("section5") String section5,
			@Param("section6") String section6,
			@Param("section7") String section7,
			@Param("section8") String section8,
			@Param("section9") String section9,
			@Param("section10") String section10, Pageable pageable);

}
