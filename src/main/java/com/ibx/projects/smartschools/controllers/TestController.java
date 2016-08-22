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
import com.ibx.projects.smartschools.models.Class_table;


@Controller
@RequestMapping("/custom/test")
public class TestController {


	//@Autowired
	//private SmartSchoolService schoolService;
	public TestController() {
		// TODO Auto-generated constructor stub
	}
	@RequestMapping(value="/getClass",method = RequestMethod.GET)
	public @ResponseBody String getAllClass(
			
			@PathParam("testparam")String testparam
			){
		
		/*try {
			List<Class_table>classtableList = (List<Class_table>) schoolService.loadList("from Class_table");
		} catch (SmartSchoolException e) {
			
			e.printStackTrace();
		}*/
		return testparam;
		
		  
	}

}
