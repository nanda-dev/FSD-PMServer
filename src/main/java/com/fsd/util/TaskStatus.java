package com.fsd.util;

public enum TaskStatus {
	INPROGRESS ("I"),
	SUSPENDED ("S"),
	COMPLETED ("C");
	
	private String statusValue;
	private TaskStatus(String statusCode) {
		this.statusValue = statusCode;
	}
	public String val() {
		return this.statusValue;
	}
}
