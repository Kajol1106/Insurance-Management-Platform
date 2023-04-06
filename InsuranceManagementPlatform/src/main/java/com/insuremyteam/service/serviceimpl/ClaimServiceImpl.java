package com.insuremyteam.service.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insuremyteam.model.Claim;
import com.insuremyteam.payloads.ClaimDTO;
import com.insuremyteam.repository.ClaimRepository;
import com.insuremyteam.service.ClaimService;

@Service
public class ClaimServiceImpl implements ClaimService {
	
	@Autowired
	private ClaimRepository claimRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ClaimDTO createClaim(ClaimDTO claimDTO) {
		Claim claim = this.modelMapper.map(claimDTO, Claim.class);
		Claim newClaim = this.claimRepo.save(claim);
		return this.modelMapper.map(newClaim, ClaimDTO.class);
	}

	
}
