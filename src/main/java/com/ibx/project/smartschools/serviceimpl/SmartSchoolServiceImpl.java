/**
 * 
 */
package com.ibx.project.smartschools.serviceimpl;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		// TODO Auto-generated constructor stub
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

}
