package com.insuremyteam.service.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insuremyteam.exception.ResourceNotFoundException;
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

	@Override
	public ClaimDTO getClaimByID(Integer claimID) {
		Claim claim = this.claimRepo.findById(claimID)
				.orElseThrow(()-> new ResourceNotFoundException("Claim ", "Claim ID ", claimID));
		return this.modelMapper.map(claim, ClaimDTO.class);
	}

	@Override
	public List<ClaimDTO> getAllClaims() {
		List<Claim> claims = this.claimRepo.findAll();
		List<ClaimDTO> allClaims = claims.stream()
				.map(claim -> this.modelMapper.map(claim, ClaimDTO.class)).collect(Collectors.toList());
		return allClaims;
	}

	@Override
	public ClaimDTO updateClaim(ClaimDTO claimDTO, Integer claimID) {
		Claim claim = this.claimRepo.findById(claimID)
				.orElseThrow(()-> new ResourceNotFoundException("Claim ", "Claim ID ", claimID));
		claim.setClaimDate(claimDTO.getClaimDate());
		claim.setClaimStatus(claimDTO.getClaimStatus());
		claim.setDescription(claimDTO.getDescription());
		
		Claim updatedClaim = this.claimRepo.save(claim);
		return this.modelMapper.map(updatedClaim, ClaimDTO.class);
	}

	@Override
	public void deleteClaimByID(Integer claimID) {
		Claim claim = this.claimRepo.findById(claimID)
				.orElseThrow(()-> new ResourceNotFoundException("Claim ", "Claim ID ", claimID));
		this.claimRepo.delete(claim);
	}

	
}
