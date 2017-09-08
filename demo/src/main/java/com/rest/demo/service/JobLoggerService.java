package com.rest.demo.service;

import java.io.File;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.demo.domain.JobLogger;
import com.rest.demo.enums.LoggerType;
import com.rest.demo.repository.JobLoggerRepository;
import com.rest.demo.request.JobLoggerRequest;

@Service
public class JobLoggerService {
	
	@Autowired
	JobLoggerRepository jobLoggerRepository;
	
	private static Logger logger;
	private static Map<String, Object> dbParams;
	public JobLoggerService() {
		logger = Logger.getLogger("MyLog");
		dbParams = new HashMap<>();
		dbParams.put("logFileFolder", "C:/Git");
	}
	
	public List<JobLogger> findJobLoggers() {
		return jobLoggerRepository.findAll();
	}
	
	public void saveJobLogger(JobLoggerRequest inRequest) throws Exception {
		boolean logToFile = inRequest.isLogToFile();
		boolean logToConsole = inRequest.isLogToConsole();
		boolean logToDatabase = inRequest.isLogToDatabase();
		boolean logMessage = inRequest.isLogMessage();
		boolean logWarning = inRequest.isLogWarning();
		boolean logError = inRequest.isLogError();
		String messageText = inRequest.getText();
		String type = inRequest.getType();
		
		messageText.trim();
		if (messageText == null || messageText.length() == 0) {
			return;
		}
		if (!logToConsole && !logToFile && !logToDatabase) {
			throw new Exception("Invalid configuration");
		}
		if (!logMessage && !logWarning && !logError) {
			throw new Exception("Error or Warning or Message must be specified");
		}
		LoggerType loggerType=LoggerType.getByName(type);

		String l = null;
		if (loggerType.equals(LoggerType.MESSAGE) && logMessage) {
			l = type + "-" +DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + "-"+ messageText;
		}
		if (loggerType.equals(LoggerType.WARNING) && logWarning) {
			l = type + "-" +DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + "-"+ messageText;
		}
		if (loggerType.equals(LoggerType.ERROR) && logError) {
			l = type + "-" +DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + "-"+ messageText;
		}

		if (l != null) {
			if(logToFile) {
				File logFile = new File(dbParams.get("logFileFolder") + "/logFile.txt");
				if (!logFile.exists()) {
					logFile.createNewFile();
				}
				FileHandler fh = new FileHandler(dbParams.get("logFileFolder") + "/logFile.txt");
				logger.addHandler(fh);
				logger.log(Level.INFO, l);
			}
			
			if(logToConsole) {
				ConsoleHandler ch = new ConsoleHandler();
				logger.addHandler(ch);
				logger.log(Level.INFO, l);
			}
			
			if (logToDatabase) {
				JobLogger e = new JobLogger();
				e.setText(l);
				e.setLoggerType(loggerType);
				jobLoggerRepository.save(e);
			}
		}

	}
}
