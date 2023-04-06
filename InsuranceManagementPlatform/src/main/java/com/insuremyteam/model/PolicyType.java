package com.insuremyteam.model;

public enum PolicyType {
	LIFE("Life"),
	TRAVEL("Travel"),
	HEALTH("Health"),
	HOMEOWNERS("Homeowners"),
	AUTOMOBILE("Automobile"),
	DISABILITY("Disability"),
	LIABILITY("Liability");
	
	private String value;
	
	PolicyType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
