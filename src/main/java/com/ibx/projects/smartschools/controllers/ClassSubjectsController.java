/**
 * 
 */
package com.ibx.projects.smartschools.controllers;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibx.projects.smartschools.models.Class_subject_table;
import com.ibx.projects.smartschools.repositories.ClassSubjectRepository;

/**
 * @author SANTOSH
 *
 */
@RestController
@RequestMapping("/custom/ClassSubject")
public class ClassSubjectsController {

	/**
	 * 
	 */
	@Autowired
	ClassSubjectRepository classSubjectRepository;
	
	final PageRequest page1 = new PageRequest(0,5, Direction.ASC, "subject1");
	
	
	public ClassSubjectsController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value="/getSubjects",method = RequestMethod.GET)
	public @ResponseBody Page<Class_subject_table> getAllClass(){
		
		Page<Class_subject_table>classSubects  = classSubjectRepository.findAll(page1);
		return classSubects;
		
		
	}
	
	@RequestMapping(value="/searchAll",method = RequestMethod.GET)
	public @ResponseBody Page<Class_subject_table> searchAll(
			@PathParam("s1")String s1,
			@PathParam("s2")String s2,
			@PathParam("s3")String s3,
			@PathParam("s4")String s4,
			@PathParam("s5")String s5,
			@PathParam("s6")String s6,
			@PathParam("s7")String s7,
			@PathParam("s8")String s8,
			@PathParam("s9")String s9,
			@PathParam("s10")String s10,
			@PathParam("s11")String s11,
			@PathParam("s12")String s12,
			@PathParam("s13")String s13,
			@PathParam("s14")String s14,
			@PathParam("s15")String s15,
			@PathParam("limit")int limit,
			@PathParam("page")int page,
			@PathParam("ordeBy")String ordeBy
			
			){
		
		int pageLimit = (limit >0 ? limit:10);
		final PageRequest page1 = new PageRequest(page,pageLimit, Direction.ASC,ordeBy);
		Page<Class_subject_table>classList =  classSubjectRepository.findByAllParams(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, page1);
		
		return classList;
		
		  
	}

}
