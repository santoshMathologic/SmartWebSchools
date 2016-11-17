/**
 * 
 */
package com.ibx.projects.smartschools.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import com.ibx.projects.smartschools.models.UserPlan;

/**
 * @author SANTOSH
 *
 */
@RepositoryRestResource

public interface UserPlanRepository extends JpaRepository<UserPlan,Long> {
	Page<UserPlan> findAll(Pageable pageable);

}
