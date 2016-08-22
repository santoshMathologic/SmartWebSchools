/**
 * 
 */
package com.ibx.projects.smartschools.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.ibx.projects.smartschools.models.Class_table;
import com.ibx.projects.smartschools.repositories.ClassRepository;



/**
 * @author SANTOSH
 *
 */
@RestController
@RequestMapping("api/custom/class")
public class ClassController {

	/**
	 * 
	 */
	@Autowired
	ClassRepository classRepository;
	
	public ClassController() {
		// TODO Auto-generated constructor stub
	}
	@RequestMapping(value="/getClass",method = RequestMethod.GET)
	public @ResponseBody String getAllClass(){
		
		List<Class_table>ClassList  = classRepository.findAll();
		  return new Gson().toJson(ClassList);
		
		
	}
	
	@RequestMapping(value="/createClass",method = RequestMethod.POST)
	public String createClass(@RequestBody Class_table classdetails){
		
	 classRepository.save(classdetails);
		return "class created Successfully";
	}

}
