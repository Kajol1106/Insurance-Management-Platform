package com.insuremyteam.service.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
