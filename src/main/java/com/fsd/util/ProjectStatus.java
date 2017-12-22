package com.fsd.util;

public enum ProjectStatus {
	INPROGRESS ("I"),
	SUSPENDED ("S"),
	COMPLETED ("C");
	
	private String statusValue;
	private ProjectStatus(String statusCode) {
		this.statusValue = statusCode;
	}
	public String val() {
		return this.statusValue;
	}
}
