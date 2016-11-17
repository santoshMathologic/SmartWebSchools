/**
 * 
 */
package com.ibx.projects.smartschools.custom.repositories;

import com.ibx.projects.smartschools.custom.utils.SelectViewModel;

/**
 * @author SANTOSH
 *
 */
public interface UserVMRepository {
	
	public SelectViewModel listUsers(String username,String sort,String sortOrder, Long page, Long size);

}
