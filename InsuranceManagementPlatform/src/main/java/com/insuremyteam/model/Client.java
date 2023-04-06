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
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cliendId;
	
	private String name;
	
	//@Past
	private String dateOfBirth;
	
	private String address;
	
	@Enumerated(EnumType.STRING)
	private ContactInformation contact;
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	private List<InsurancePolicy> insurancePolicies = new ArrayList<>();
}
