
package com.ibx.projects.smartschools.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author SANTOSH
 *
 */
@RestController
@RequestMapping("/api/v1/trainStation")
public class TrainStationController {

	/**
	 * 
	 */
	public TrainStationController() {
	}
	
	@RequestMapping(value="/getStationInfo",method = RequestMethod.GET)
	public @ResponseBody String provideStationInfo(){
		return "to get the Train station information please fetch the URl";
 

        }

}
