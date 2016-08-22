/**
 * 
 */
package com.ibx.projects.smartschools.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ibx.projects.smartschools.models.Class_table;



/**
 * @author SANTOSH
 *
 */
@RepositoryRestResource
public interface ClassRepository extends JpaRepository<Class_table, Long> {



}
