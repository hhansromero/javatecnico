package com.rest.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.demo.domain.JobLogger;
import com.rest.demo.request.JobLoggerRequest;
import com.rest.demo.service.JobLoggerService;

@RestController
public class JobLoggerController {

	@Autowired
	JobLoggerService jobLoggerService;
	
	@RequestMapping(path = "/jobLoggers", method = RequestMethod.POST)
	void logMessage(@RequestBody JobLoggerRequest inRequest){
		try {
			
			jobLoggerService.saveJobLogger(inRequest);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping(path = "/jobLoggers")
	List<JobLogger> logMessageList(){
		return jobLoggerService.findJobLoggers();
	}

	@RequestMapping(path = "/jobLoggers2")
	List<JobLogger> newMethod(){
		return jobLoggerService.findJobLoggers();
	}
	
}
