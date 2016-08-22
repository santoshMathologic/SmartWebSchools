/**
 * 
 */
package com.ibx.projects.smartschools.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import com.ibx.projects.smartschools.models.Role;
import com.ibx.projects.smartschools.models.User;



/**
 * @author SANTOSH
 *
 */
@RepositoryRestResource

public interface RoleRepository extends JpaRepository<Role, Long> {

	Page<Role> findAll(Pageable pageable);


}
