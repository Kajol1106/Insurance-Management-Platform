package com.insuremyteam.payloads;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.insuremyteam.model.Claim;
import com.insuremyteam.model.PolicyType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class InsurancePolicyDTO {
	private Integer policyNumber;
	
	@Enumerated(EnumType.STRING)
	private PolicyType policyType;
	
	private Double coverageAmount;
	private Boolean premiumClient;
	private String startDate;
	private String endDate;
	private ClientDTO clientDTO;
	private List<Claim> claims = new ArrayList<>();
}
