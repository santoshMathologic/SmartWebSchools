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
	
	@Query("Select t from User as t where ( t.username LIKE %:username% or :username is '%%' or :username is null ) AND "
			+ "( t.firstName LIKE %:firstName% or :firstName is '%%' or :firstName is null ) AND "
			+ "( t.lastName LIKE %:lastName% or :lastName is '%%' or :lastName is null ) AND "
			+ "( t.email LIKE %:email% or :email is '%%' or :email is null ) AND "
			+ "( t.role.name LIKE %:role% or :role is '%%' or :role is null ) AND "
			+ "( t.password LIKE %:password% or :password is '%%' or :password is null ) AND "
			+ "( t.isActive = :isActive or :isActive = null )")
	Page<Class_table> findByAllParams(@Param("username") String username,
			@Param("firstName") String firstName,
			@Param("lastName") String lastName,
			@Param("email") String email,
			@Param("role") String role,
			@Param("password") String password,
			@Param("isActive") Boolean isActive, Pageable pageable);

}
