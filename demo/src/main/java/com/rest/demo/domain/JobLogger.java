package com.rest.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.rest.demo.enums.LoggerType;

@Entity
public class JobLogger {
	
	@Id
	@GeneratedValue
	Long id;
	String text;
	LoggerType loggerType;
	
	public JobLogger() {
		super();
	}

	public JobLogger(String text, LoggerType loggerType) {
		super();
		this.text = text;
		this.loggerType = loggerType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LoggerType getLoggerType() {
		return loggerType;
	}

	public void setLoggerType(LoggerType loggerType) {
		this.loggerType = loggerType;
	}

}
