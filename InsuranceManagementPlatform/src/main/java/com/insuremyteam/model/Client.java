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
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cliendId;
	
	@Pattern(regexp = "[A-Z][a-z]*", message = "name should start with capital letter")
	private String name;
	
	@Pattern(regexp = "dd-mm-yyyy", message = "Please provice date of birth format dd-mm-yyyy in this way")
	private String dateOfBirth;
	
	private String address;
	
	@Enumerated(EnumType.STRING)
	private ContactInformation contact;
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	private List<InsurancePolicy> insurancePolicies = new ArrayList<>();
}
