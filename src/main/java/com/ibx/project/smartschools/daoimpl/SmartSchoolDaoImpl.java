/**
 * 
 */
package com.ibx.project.smartschools.daoimpl;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibx.project.smartschools.dao.SmartSchoolDao;
import com.ibx.project.smartschools.exception.SmartSchoolException;

/**
 * @author SANTOSH
 *
 */
@Component
public class SmartSchoolDaoImpl implements SmartSchoolDao {

	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	SessionFactory sessionFactory;
	Session session = null;
	public SmartSchoolDaoImpl() {
		 session = sessionFactory.getCurrentSession();
	}

	@Override
	
	public Collection<?> loadList(String stringQuery) throws SmartSchoolException {
	
		Query query;
		query =session.createQuery(stringQuery);
		query.setCacheable(true);		
		return query.list();
	
	}

	public Session getSession() {
		return session;
	}

	

	public void setSession(Session session) {
		this.session = session;
	}

	

}
