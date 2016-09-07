/**
 * 
 */
package com.ibx.projects.smartschools.custom.repositories;

import com.ibx.projects.smartschools.custom.utils.SelectViewModel;

/**
 * @author SANTOSH
 *
 */
public interface StationVMRepository {
	public SelectViewModel listStations(String code,String name,String sort, Long page, Long size);
	
	public SelectViewModel findByCode(String code,String sort, Long page, Long size);
	

}
