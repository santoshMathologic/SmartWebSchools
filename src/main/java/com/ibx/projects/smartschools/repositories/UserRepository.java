/**
 * 
 */
package com.ibx.projects.smartschools.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ibx.projects.smartschools.models.User;



/**
 * @author SANTOSH
 *
 */
@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {



}
