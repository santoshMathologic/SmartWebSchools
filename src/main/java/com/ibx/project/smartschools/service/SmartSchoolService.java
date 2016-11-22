/**
 * 
 */
package com.ibx.project.smartschools.service;

import java.util.Collection;

import com.ibx.project.smartschools.exception.SmartSchoolException;

/**
 * @author SANTOSH
 *
 */
public interface SmartSchoolService {
	
	Collection<?> loadList(String query)throws SmartSchoolException;
	void saveInDb(Object object)throws SmartSchoolException;

	void deleteFromDb(String query)throws SmartSchoolException;

	void updateInDb(Object object)throws SmartSchoolException;

	Object loadUniqueObject(String query)throws SmartSchoolException;
	
	Object DeleteUniqueObject(String query)throws SmartSchoolException;

}
