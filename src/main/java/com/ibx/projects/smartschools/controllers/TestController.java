package com.ibx.projects.smartschools.controllers;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibx.project.smartschools.exception.SmartSchoolException;
import com.ibx.project.smartschools.service.SmartSchoolService;
import com.ibx.projects.smartschools.models.Class_subject_table;
import com.ibx.projects.smartschools.models.Class_table;
import com.ibx.projects.smartschools.repositories.ClassSubjectRepository;


@Controller
@RequestMapping("api/v1/test")
public class TestController {


	@Autowired
	private ClassSubjectRepository classSubjectRepository;
	
	 @Autowired
	 SmartSchoolService smartSchoolService;
	 
	 
	public TestController() {
		
	}
	
	
	
	@RequestMapping(value="/testClass",method = RequestMethod.GET)
	public @ResponseBody void testAllClass(){
		
		
		try {
		@SuppressWarnings("unchecked")
		List<Class_table> Class_tableList = (List<Class_table>) smartSchoolService.loadList(" from Class_table");
		System.out.println(""+Class_tableList);
		} catch (SmartSchoolException e) {
			
			e.printStackTrace();
		}
		
		// return new Gson().toJson();
		
	}
	
			
			
			
	
	
	@RequestMapping(value="/getClass",method = RequestMethod.GET)
	public @ResponseBody Page<Class_subject_table> getAllClass(
			
			@PathParam("id")Long id
			){
		final PageRequest page1 = new PageRequest(0,5, Direction.ASC, "subject1");
		Page<Class_subject_table>classList =  classSubjectRepository.findSubjectById(id,page1);
		
		return classList;
		
	}
	
	@RequestMapping(value="/getSubject",method = RequestMethod.GET)
	public @ResponseBody Optional<Class_subject_table> getSubjects(
			@PathParam("subjectName")String subjectName
			){
		
		Optional<Class_subject_table>classList =  classSubjectRepository.findBysubject1(subjectName);
		
		return classList;
		
		  
	}
	
	@RequestMapping(value="/findAll",method = RequestMethod.GET)
	public @ResponseBody Page<Class_subject_table> findAll(
			@PathParam("s1")String s1,
			@PathParam("s2")String s2,
			@PathParam("s3")String s3,
			@PathParam("s4")String s4,
			@PathParam("s5")String s5,
			@PathParam("s6")String s6,
			@PathParam("s7")String s7,
			@PathParam("s8")String s8,
			@PathParam("s9")String s9,
			@PathParam("s10")String s10
			){
		final PageRequest page1 = new PageRequest(0,5, Direction.ASC, "subject1");
		Page<Class_subject_table>classList =  classSubjectRepository.findByAllParams(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, page1);
		
		return classList;
		
		  
	}

}
