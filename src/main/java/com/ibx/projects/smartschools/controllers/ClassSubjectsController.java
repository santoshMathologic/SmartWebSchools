/**
 * 
 */
package com.ibx.projects.smartschools.controllers;

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

}
