/**
 * 
 */
package com.ibx.project.smartschools.serviceimpl;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ibx.project.smartschools.dao.SmartSchoolDao;
import com.ibx.project.smartschools.exception.SmartSchoolException;
import com.ibx.project.smartschools.service.SmartSchoolService;

/**
 * @author SANTOSH
 *
 */
@Service
public class SmartSchoolServiceImpl implements SmartSchoolService,Serializable {

	/**
	 * 
	 */
	@Autowired
	private SmartSchoolDao smartSchoolDao;
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public SmartSchoolServiceImpl() {
	}

	@Override
	
	public Collection<?> loadList(String query) throws SmartSchoolException {
		return smartSchoolDao.loadList(query);
		
	}

	
	
	///  Getter and Setter
	public SmartSchoolDao getSmartSchoolDao() {
		return smartSchoolDao;
	}

	public void setSmartSchoolDao(SmartSchoolDao smartSchoolDao) {
		this.smartSchoolDao = smartSchoolDao;
	}

	@Override
	public void saveInDb(Object object) throws SmartSchoolException {
		smartSchoolDao.saveInDb(object);
		
	}

	@Override
	public void deleteFromDb(String query) throws SmartSchoolException {
		smartSchoolDao.deleteFromDb(query);
	}

	@Override
	public void updateInDb(Object object) throws SmartSchoolException {
		smartSchoolDao.updateInDb(object);
		
	}

	@Override
	public Object loadUniqueObject(String query) throws SmartSchoolException {
		return smartSchoolDao.loadUniqueObject(query);
	}

	@Override
	public Object DeleteUniqueObject(String query) throws SmartSchoolException {
		return smartSchoolDao.DeleteUniqueObject(query);
	}

}
