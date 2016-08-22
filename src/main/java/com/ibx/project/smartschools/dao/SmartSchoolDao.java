/**
 * 
 */
package com.ibx.project.smartschools.dao;

import java.util.Collection;
import java.util.List;

import com.ibx.project.smartschools.exception.SmartSchoolException;


/**
 * @author SANTOSH
 *
 */
public interface SmartSchoolDao {
	
	Collection<?> loadList(String query)throws SmartSchoolException;


}
