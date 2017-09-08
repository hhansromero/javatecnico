package com.rest.demo.enums;

import org.springframework.util.StringUtils;

public enum LoggerType {

    MESSAGE("M"),
    WARNING("W"),
    ERROR("E");
	
	private String name;
	
	LoggerType(String name) {
        this.name = name;
    }

	public String getName() {
		return name;
	}
 
    public static LoggerType getByName(final String name) throws IllegalArgumentException {
        for (LoggerType loggerType : values()) {
            String loggerTypeName = loggerType.getName();
            if (StringUtils.startsWithIgnoreCase(loggerTypeName, name)) {
                return loggerType;
            }
        }
        throw new IllegalArgumentException("Cannot find logger type with value: " + name);
    }
    
}
