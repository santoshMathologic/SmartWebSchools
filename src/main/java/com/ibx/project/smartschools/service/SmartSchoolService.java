/**
 * 
 */
package com.ibx.project.smartschools.service;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ibx.project.smartschools.exception.SmartSchoolException;


/**
 * @author SANTOSH
 *
 */

public interface SmartSchoolService{
	Collection<?> loadList(String query)throws SmartSchoolException;

}
