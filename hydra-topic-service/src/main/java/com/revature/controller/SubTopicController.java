package com.revature.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Subtopic;
import com.revature.model.SubtopicName;
import com.revature.model.SubtopicType;
import com.revature.model.TopicName;
import com.revature.services.SubTopicService;
import com.revature.services.TopicService;



@RestController
@RequestMapping(value = "/api/v2/Subtopic/")
public class SubTopicController {
	
	  @Autowired
	  TopicService topicService;

	  @Autowired
	  SubTopicService subTopicService;

	  @RequestMapping(value = "Add", method = RequestMethod.POST)
	  public void addSubTopicName(HttpServletRequest request) {
	    SubtopicType type = subTopicService.getSubtopicType(Integer.parseInt(request.getParameter("typeId")));
	    TopicName topic = topicService.getTopicName(Integer.parseInt(request.getParameter("topicId")));
	    SubtopicName subtopic = new SubtopicName(request.getParameter("subtopicName"), topic, type);
	    subTopicService.addOrUpdateSubtopicName(subtopic);
	  }
	  
	  /**
	   * 
	   * @param jsonObj
	   * @author Samuel Louis-Pierre, Avant Mathur
	   * 
	   *         REST controller to add existing subtopic to specified batch
	   * @throws CustomException
	   */

	  @RequestMapping(value = "addSubtopic", method = RequestMethod.POST, produces = "application/json")
	  public void addSubtopic(@RequestBody String jsonObj) /*throws CustomException*/ {

	    Subtopic st = null;
	    try {
	      st = new ObjectMapper().readValue(jsonObj, Subtopic.class);
	    } catch (IOException e) {
	    	System.out.println(("Error"));
	      //throw new CustomException(e);
	    }

	    subTopicService.updateSubtopic(st);
	  }



}
