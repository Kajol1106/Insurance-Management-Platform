package com.insuremyteam.service;

import com.insuremyteam.payloads.InsurancePolicyDTO;
import java.util.List;

public interface InsurancePolicyService {
	public InsurancePolicyDTO createInsurancePlicy(InsurancePolicyDTO insurancePolicyDTO);
	public InsurancePolicyDTO getInsurancePolicyById(Integer policyID);
	public List<InsurancePolicyDTO> getAllInsurancePolicies();
	public InsurancePolicyDTO updateInsurancePolicy(InsurancePolicyDTO insurancePolicyDTO, Integer policyID);
	public void deleteInsurancePolicy(Integer policyID);
}
