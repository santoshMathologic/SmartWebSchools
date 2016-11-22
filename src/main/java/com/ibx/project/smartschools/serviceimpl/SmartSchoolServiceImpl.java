/**
 * 
 */
package com.ibx.project.smartschools.serviceimpl;

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

@Service ("SmartSchoolServiceManger")
public class SmartSchoolServiceImpl implements SmartSchoolService {

	@Autowired
	SmartSchoolDao smartschooldao;
	@Override
	public Collection<?> loadList(String query) throws SmartSchoolException {
		return smartschooldao.loadList(query);
	}

	@Override
	public void saveInDb(Object object) throws SmartSchoolException {
		smartschooldao.saveInDb(object);

	}

	@Override
	public void deleteFromDb(String query) throws SmartSchoolException {
		smartschooldao.deleteFromDb(query);
	}

	@Override
	public void updateInDb(Object object) throws SmartSchoolException {
		smartschooldao.updateInDb(object);

	}

	@Override
	public Object loadUniqueObject(String query) throws SmartSchoolException {
		return smartschooldao.loadUniqueObject(query);
	}

	@Override
	public Object DeleteUniqueObject(String query) throws SmartSchoolException {
		return smartschooldao.DeleteUniqueObject(query);
	}

}
