/**
 * 
 */
package com.ibx.projects.smartschools.helpers;

import org.springframework.stereotype.Service;

/**
 * @author SANTOSH
 *
 */
@Service
public interface CSVtoDataBase {
	 boolean processRecordToTable(String[] columns);

}


