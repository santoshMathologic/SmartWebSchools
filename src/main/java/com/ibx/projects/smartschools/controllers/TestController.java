package com.ibx.projects.smartschools.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibx.project.smartschools.exception.SmartSchoolException;
import com.ibx.project.smartschools.service.SmartSchoolService;
import com.ibx.projects.smartschools.models.Class_subject_table;
import com.ibx.projects.smartschools.models.Class_table;
import com.ibx.projects.smartschools.repositories.ClassSubjectRepository;


@Controller
@RequestMapping("/custom/test")
public class TestController {


	@Autowired
	private ClassSubjectRepository classSubjectRepository;
	public TestController() {
		// TODO Auto-generated constructor stub
	}
	@RequestMapping(value="/getClass",method = RequestMethod.GET)
	public @ResponseBody Page<Class_subject_table> getAllClass(
			
			@PathParam("id")Long id
			){
		final PageRequest page1 = new PageRequest(0,5, Direction.ASC, "subject1");
		Page<Class_subject_table>classList =  classSubjectRepository.findSubjectById(id,page1);
		
		return classList;
		
		  
	}

}
