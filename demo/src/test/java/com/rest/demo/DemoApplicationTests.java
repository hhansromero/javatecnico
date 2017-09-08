package com.rest.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rest.demo.request.JobLoggerRequest;
import com.rest.demo.service.JobLoggerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	JobLoggerService jobLoggerService;
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void saveLog() throws Exception {
		JobLoggerRequest inRequest= new JobLoggerRequest();
		inRequest.setLogToFile(true);
		inRequest.setLogToConsole(false);
		inRequest.setLogToDatabase(false);
		inRequest.setLogMessage(true);
		inRequest.setLogWarning(true);
		inRequest.setLogError(true);
		inRequest.setText("testttt");
		inRequest.setType("M");
		
		jobLoggerService.saveJobLogger(inRequest);
	}
	
}
