package com.insuremyteam.model;

public enum ClaimStatus {
	PENDING("Pending"),
	APPROVED("Approved"),
	REJECTED("Rejected");
	
	private String value;
	
	ClaimStatus(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
