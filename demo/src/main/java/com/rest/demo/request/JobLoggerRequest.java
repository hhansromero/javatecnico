package com.rest.demo.request;

public class JobLoggerRequest {
	
	private boolean logToFile;
	private boolean logToConsole;
	private boolean logToDatabase;
	private boolean logMessage;
	private boolean logWarning;
	private boolean logError;
	private String text;
	private String type;
	
	public boolean isLogToFile() {
		return logToFile;
	}
	public void setLogToFile(boolean logToFile) {
		this.logToFile = logToFile;
	}
	public boolean isLogToConsole() {
		return logToConsole;
	}
	public void setLogToConsole(boolean logToConsole) {
		this.logToConsole = logToConsole;
	}
	public boolean isLogToDatabase() {
		return logToDatabase;
	}
	public void setLogToDatabase(boolean logToDatabase) {
		this.logToDatabase = logToDatabase;
	}
	public boolean isLogMessage() {
		return logMessage;
	}
	public void setLogMessage(boolean logMessage) {
		this.logMessage = logMessage;
	}
	public boolean isLogWarning() {
		return logWarning;
	}
	public void setLogWarning(boolean logWarning) {
		this.logWarning = logWarning;
	}
	public boolean isLogError() {
		return logError;
	}
	public void setLogError(boolean logError) {
		this.logError = logError;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
