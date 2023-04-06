package com.insuremyteam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insuremyteam.payloads.InsurancePolicyDTO;
import com.insuremyteam.service.InsurancePolicyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/policies")
public class InsurancePolicyController {

	@Autowired
	private InsurancePolicyService insurancePolicyService;
	
	@PostMapping("/policy")
	public ResponseEntity<InsurancePolicyDTO> createInsurancePolicy(@Valid @RequestBody InsurancePolicyDTO insurancePolicyDTO) {
		InsurancePolicyDTO createdInsurancePolicy = this.insurancePolicyService.createInsurancePlicy(insurancePolicyDTO);
		return new ResponseEntity<InsurancePolicyDTO>(createdInsurancePolicy, HttpStatus.CREATED);
	}
	
}
