/**
 * 
 */
package com.ibx.projects.smartschools.controllers;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.ibx.project.smartschools.exception.FileEmptyException;

import com.ibx.projects.smartschools.models.Upload;
import com.ibx.projects.smartschools.repositories.UploadRepository;
import com.opencsv.CSVReader;



/**
 * @author SANTOSH
 *
 */
@RestController
@RequestMapping("api/v1/Upload")
public class UploadController {


	@Autowired
	UploadRepository uploadRepository;
	
	

	
	public UploadController() {
		// TODO Auto-generated constructor stub
	}
@RequestMapping(value="/getUpload",method = RequestMethod.GET)
	public @ResponseBody Page<Upload> getAllClass(
			@PathParam("ordeBy") String ordeBy,
			@PathParam("limit") int limit,
			@PathParam("page")int page
			){
		
		
		Page<Upload>ClassList  = uploadRepository.findAll(new PageRequest(page,limit, Direction.ASC,ordeBy));
		  return ClassList;
		
		  
	}
	
	@RequestMapping(value="/createUpload",method = RequestMethod.POST)
	
	public @ResponseBody String createUpload(@RequestParam("Uploadfile") MultipartFile fileDetails,HttpServletRequest request)throws FileEmptyException {
		
		
		if (fileDetails == null) {
	        throw new FileEmptyException ("for uploading, parameter name must be");
	    }

	   
		Path currentRelativePath = Paths.get("");
	   	String s = currentRelativePath.toAbsolutePath().toString();
	   	String nameTrainDetails = s+"/uploads";
	   	
	   	 
	   	
	  
	     
	    
	     if (!fileDetails.isEmpty()) {
	         try {
	        	 // writes to the buffer contents of the csv file
	        	 File file = new File(nameTrainDetails);
	        	 file.mkdirs();
	        	 nameTrainDetails += "/"+fileDetails.getOriginalFilename();
	        	 nameTrainDetails = nameTrainDetails.replace("%20", " ");
	        	 nameTrainDetails = nameTrainDetails.replace("\\", "/");
	        	 Upload uploadObject = new Upload();
	        	 file =  new File(nameTrainDetails);
	             byte[] bytes = fileDetails.getBytes();
	             BufferedOutputStream stream =
	                     new BufferedOutputStream(new FileOutputStream(file));
	             uploadObject.setData(bytes);
	             uploadRepository.save(uploadObject);
	             stream.write(bytes);
	             stream.close();

	             if(!fileDetails.getOriginalFilename().contains(".csv")){
	                 return "Uploaded file is not CSV";
	             }
	             StringBuilder builder = new StringBuilder();
	             
	             CSVReader reader = new CSVReader(new FileReader(nameTrainDetails),',','\'',1);
	             for (String[] columns; (columns = reader.readNext()) != null;) {
	            	 builder.append(columns);
	            	  
	            
	            		      
	             }
	             

	            
	             return "You successfully uploaded " + nameTrainDetails + "!";
	         } catch (Exception e) {
	             return "You failed to upload " + nameTrainDetails + " => " + e.getMessage();
	         }
	     } else {
	         return "You failed to upload " + nameTrainDetails + " because the file was empty.";
	     }
		
		
		
	}
	
	@RequestMapping(value="/findAllUploads", method= RequestMethod.GET)
	public  @ResponseBody Page<Upload> activateUser(
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
		
		Page<Upload>UploadsList =  uploadRepository.findByAllParams(className, section_1, section_2, section_3, section_4, section_5, section_6, section_7, section_8, section_9, section_10, pageRequest);
		
		return UploadsList ;
	}
	
	
	

}
