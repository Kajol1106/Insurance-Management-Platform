package com.insuremyteam.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Claim {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer claimNumber;
	private String description;
	private String claimDate;
	
	@Enumerated(EnumType.STRING)
	private ClaimStatus claimStatus;
	
	@ManyToOne
	@JoinColumn(name = "policy_number")
	private InsurancePolicy insurancePolicy;
}
