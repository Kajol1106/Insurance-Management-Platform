package com.insuremyteam.model;

public enum ContactInformation {
	PHONE("Phone"),
	EMAIL("Email"),
	POST("Post");
	
	private String value;
	
	ContactInformation(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
