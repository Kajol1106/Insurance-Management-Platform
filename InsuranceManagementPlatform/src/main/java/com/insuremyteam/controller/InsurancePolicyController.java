package com.insuremyteam.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	//create new insurance policy
	@PostMapping()
	public ResponseEntity<InsurancePolicyDTO> createInsurancePolicy(@Valid @RequestBody InsurancePolicyDTO insurancePolicyDTO) {
		InsurancePolicyDTO createdInsurancePolicy = this.insurancePolicyService.createInsurancePlicy(insurancePolicyDTO);
		return new ResponseEntity<InsurancePolicyDTO>(createdInsurancePolicy, HttpStatus.CREATED);
	}
	
	//fetch a specific insurance policy by id
	@GetMapping("/{id}")
	public ResponseEntity<InsurancePolicyDTO> getInsurancePolicyByID(@PathVariable("id") Integer policyID) {
		InsurancePolicyDTO insurancePolicy = this.insurancePolicyService.getInsurancePolicyById(policyID);
		return new ResponseEntity<InsurancePolicyDTO>(insurancePolicy, HttpStatus.OK);
	}
	
	//fetch all insurance policies
	@GetMapping()
	public ResponseEntity<List<InsurancePolicyDTO>> getAllInsurancePolicies() {
		List<InsurancePolicyDTO> policies = this.insurancePolicyService.getAllInsurancePolicies();
		return new ResponseEntity<List<InsurancePolicyDTO>>(policies, HttpStatus.OK);
	}
	
	//update an insurance policy
	@PutMapping("/{id}")
	public ResponseEntity<InsurancePolicyDTO> updateInsurancePolicyByID(@RequestBody InsurancePolicyDTO insurancePolicyDTO, @PathVariable("id") Integer policyID) {
		InsurancePolicyDTO insurancePolicy = this.insurancePolicyService.updateInsurancePolicy(insurancePolicyDTO, policyID);
		return new ResponseEntity<InsurancePolicyDTO>(insurancePolicy, HttpStatus.OK);
	}
	
	//delete an insurance policy
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteInsurancePolicyByID(@PathVariable("id") Integer policyID) {
		this.insurancePolicyService.deleteInsurancePolicy(policyID);
		return new ResponseEntity<>(Map.of("Message ", "Insurance Policy Deleted "), HttpStatus.OK);
	}
	
}
