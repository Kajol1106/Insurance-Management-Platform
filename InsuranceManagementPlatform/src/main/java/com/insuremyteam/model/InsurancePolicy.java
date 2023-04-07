package com.insuremyteam.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class InsurancePolicy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer policyNumber;
	
	@Enumerated(EnumType.STRING)
	private PolicyType policyType;
	
	private Double coverageAmount;
	
	private Boolean premiumClient;
	
	@Pattern(regexp = "dd-mm-yyyy", message = "Please provice date format dd-mm-yyyy in this way")
	private String startDate;
	
	@Pattern(regexp = "dd-mm-yyyy", message = "Please provice date format dd-mm-yyyy in this way")
	private String endDate;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	
	@OneToMany(mappedBy = "insurancePolicy", cascade = CascadeType.ALL)
	private List<Claim> claims = new ArrayList<>();
}
