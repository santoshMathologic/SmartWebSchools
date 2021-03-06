/**
 * 
 */
package com.ibx.project.smartschools.daoimpl;

import java.util.Collection;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ibx.project.smartschools.dao.SmartSchoolDao;
import com.ibx.project.smartschools.exception.SmartSchoolException;

/**
 * @author SANTOSH
 *
 */
@Repository ("schoolDao")
public class SmartSchoolDaoImpl implements SmartSchoolDao {

	@Autowired
	private SessionFactory sessionFactory;
	public SmartSchoolDaoImpl() {
	}

	@Override
	
	public Collection<?> loadList(String stringQuery) throws SmartSchoolException {
	
		Query query;
		query =sessionFactory.openSession().createQuery(stringQuery);
		query.setCacheable(true);		
		return query.list();
	
	}

	

	@Override
	public void saveInDb(Object object) throws SmartSchoolException {
		
	}

	@Override
	public void deleteFromDb(String query) throws SmartSchoolException {
		
	}

	@Override
	public void updateInDb(Object object) throws SmartSchoolException {
		
	}

	@Override
	public Object loadUniqueObject(String query) throws SmartSchoolException {
		return null;
	}

	@Override
	public Object DeleteUniqueObject(String query) throws SmartSchoolException {
		return null;
	}

	

}
