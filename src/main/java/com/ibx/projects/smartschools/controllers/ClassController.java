/**
 * 
 */
package com.ibx.projects.smartschools.controllers;


import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibx.projects.smartschools.models.Class_table;
import com.ibx.projects.smartschools.repositories.ClassRepository;



/**
 * @author SANTOSH
 *
 */
@RestController
@RequestMapping("/custom/classes")
public class ClassController {


	@Autowired
	ClassRepository classRepository;
	
	public ClassController() {
		// TODO Auto-generated constructor stub
	}
@RequestMapping(value="/getClass",method = RequestMethod.GET)
	public @ResponseBody Page<Class_table> getAllClass(
			@PathParam("ordeBy") String ordeBy,
			@PathParam("limit") int limit,
			@PathParam("page")int page
			){
		
		Page<Class_table>ClassList  = classRepository.findAll(new PageRequest(page,limit, Direction.ASC,ordeBy));
		  return ClassList;
		
		
	}
	
	@RequestMapping(value="/createClass",method = RequestMethod.POST)
	public String createClass(@RequestBody Class_table classdetails){
		
	 classRepository.save(classdetails);
		return "class created Successfully";
	}
	
	@RequestMapping(value="/findAllClasses", method= RequestMethod.GET)
	public  @ResponseBody Page<Class_table> activateUser(
			@PathParam("className") String className,
			@PathParam("section_1") String section_1,
			@PathParam("section_2") String section_2,
			@PathParam("section_3") String section_3,
			@PathParam("section_4") String section_4,
			@PathParam("section_5") String section_5,
			@PathParam("section_6") String section_6,
			@PathParam("section_7") String section_7,
			@PathParam("section_8") String section_8,
			@PathParam("section_9") String section_9,
			@PathParam("section_10") String section_10,
			@PathParam("limit") int limit,
			@PathParam("page") int page,
			@PathParam("orderBy")String orderBy) {
		System.out.print("" + className);
		
		PageRequest pageRequest = new PageRequest(page,limit);
		
		Page<Class_table>ClassList =  classRepository.findByAllParams(className, section_1, section_2, section_3, section_4, section_5, section_6, section_7, section_8, section_9, section_10, pageRequest);
		
		return ClassList;
	}

}
