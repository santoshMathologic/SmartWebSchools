/**
 * 
 */
package com.ibx.projects.smartschools.custom.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ibx.projects.smartschools.custom.utils.SelectViewModel;

/**
 * @author SANTOSH
 *
 */
@Repository
public class UserVMRepositoryImpl implements UserVMRepository {

	@PersistenceContext
	private EntityManager entityManager;
	/**
	 * 
	 */
	public UserVMRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}

	@Transactional(readOnly = true)
	@Override
	public SelectViewModel listUsers(String username, String sort, String sortOrder, Long page, Long size) {
		
		
		String FROM = "FROM user_plan AS up INNER JOIN USER AS u ON (up.user_id = u.id) ORDER BY up.plan_name LIMIT 0, 10";
		String query1 = "SELECT COUNT(u.id) " + FROM;
		
		String query2 = "SELECT up.owner,up.plan_name" + FROM
		+ " ORDER BY " + sort + " LIMIT :start, :offset";
		Query query2f = entityManager.createNativeQuery(query2);
		return null;
	}

}
