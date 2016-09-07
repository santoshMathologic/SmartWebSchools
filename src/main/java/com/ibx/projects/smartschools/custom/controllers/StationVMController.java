/**
 * 
 */
package com.ibx.projects.smartschools.custom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibx.projects.smartschools.custom.repositories.StationVMRepository;
import com.ibx.projects.smartschools.custom.utils.SelectViewModel;

/**
 * @author SANTOSH
 *
 */
@Controller
@RequestMapping("/api/custom/Stations")
public class StationVMController {

	@Autowired
	StationVMRepository stationVMRepository;
	
	public StationVMController() {
	
	}
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody SelectViewModel listStations(
			
			@RequestParam(value = "code", required = false) String code,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "page", required = false, defaultValue = "0") Long page,
			@RequestParam(value = "size", required = false, defaultValue = "10") Long size) {
		SelectViewModel result = null;
		
		result = stationVMRepository.listStations(code, name,sort, page, size);
		return result;
		
		
		
		
	}
	@RequestMapping(value = "/listCode", method = RequestMethod.GET)
	public @ResponseBody SelectViewModel stationByCode(
			
			@RequestParam(value = "code", required = false) String code,
			
			@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "page", required = false, defaultValue = "0") Long page,
			@RequestParam(value = "size", required = false, defaultValue = "10") Long size) {
		SelectViewModel result = null;
		
		result = stationVMRepository.findByCode(code,sort, page, size);
		return result;
		
		
		
		
	}

}
