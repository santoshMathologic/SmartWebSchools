/**
 * 
 */
package com.ibx.projects.smartschools.helpers;

import org.springframework.stereotype.Service;

/**
 * @author SANTOSH
 *
 */
@Service("TrainTimeTableDetails")
public class TrainTimeTableDetails implements CSVtoDataBase {

	/**
	 * 
	 */
	public TrainTimeTableDetails() {
	}

	
	@Override
	public boolean processRecordToTable(String[] columns) {
		
		return false;
	}

}
