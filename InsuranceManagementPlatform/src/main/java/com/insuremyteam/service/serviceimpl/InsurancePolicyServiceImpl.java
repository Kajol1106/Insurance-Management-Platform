package com.insuremyteam.service.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insuremyteam.exception.ResourceNotFoundException;
import com.insuremyteam.model.Client;
import com.insuremyteam.model.InsurancePolicy;
import com.insuremyteam.payloads.InsurancePolicyDTO;
import com.insuremyteam.repository.InsurancePolicyRepository;
import com.insuremyteam.service.InsurancePolicyService;

@Service
public class InsurancePolicyServiceImpl implements InsurancePolicyService {

	@Autowired
	private InsurancePolicyRepository insurancePolicyRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public InsurancePolicyDTO createInsurancePlicy(InsurancePolicyDTO insurancePolicyDTO) {
		InsurancePolicy insurancePolicy = this.modelMapper.map(insurancePolicyDTO, InsurancePolicy.class);
		InsurancePolicy savedInsurancePolicy = this.insurancePolicyRepo.save(insurancePolicy);
		return this.modelMapper.map(savedInsurancePolicy, InsurancePolicyDTO.class);
	}

	@Override
	public InsurancePolicyDTO getInsurancePolicyById(Integer policyID) {
		InsurancePolicy insurancePolicy = this.insurancePolicyRepo.findById(policyID)
				.orElseThrow(()-> new ResourceNotFoundException("Insurance Policy ", "Insurance Policy ID ", policyID));
		return this.modelMapper.map(insurancePolicy, InsurancePolicyDTO.class);
	}

	@Override
	public List<InsurancePolicyDTO> getAllInsurancePolicies() {
		List<InsurancePolicy> policies = this.insurancePolicyRepo.findAll();
		List<InsurancePolicyDTO> allPolicies = policies.stream()
				.map(policy -> this.modelMapper.map(policy, InsurancePolicyDTO.class)).collect(Collectors.toList());
		return allPolicies;
	}

	@Override
	public InsurancePolicyDTO updateInsurancePolicy(InsurancePolicyDTO insurancePolicyDTO, Integer policyID) {
		InsurancePolicy insurancePolicy = this.insurancePolicyRepo.findById(policyID)
				.orElseThrow(()-> new ResourceNotFoundException("Insurance Policy ", "Insurance Policy ID ", policyID));
		insurancePolicy.setCoverageAmount(insurancePolicyDTO.getCoverageAmount());
		insurancePolicy.setEndDate(insurancePolicyDTO.getEndDate());
		insurancePolicy.setPolicyType(insurancePolicyDTO.getPolicyType());
		insurancePolicy.setPremiumClient(insurancePolicyDTO.getPremiumClient());
		insurancePolicy.setEndDate(insurancePolicyDTO.getEndDate());
		
		InsurancePolicy updatedPolicy = this.insurancePolicyRepo.save(insurancePolicy);
		return this.modelMapper.map(updatedPolicy, InsurancePolicyDTO.class);
	}

	@Override
	public void deleteInsurancePolicy(Integer policyID) {
		InsurancePolicy insurancePolicy = this.insurancePolicyRepo.findById(policyID)
				.orElseThrow(()-> new ResourceNotFoundException("Insurance Policy ", "Insurance Policy ID ", policyID));
		this.insurancePolicyRepo.delete(insurancePolicy);
	}

}
