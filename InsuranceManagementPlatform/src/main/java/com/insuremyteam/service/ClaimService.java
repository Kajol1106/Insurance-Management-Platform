package com.insuremyteam.service;

import java.util.List;

import com.insuremyteam.payloads.ClaimDTO;

public interface ClaimService {
	public ClaimDTO createClaim(ClaimDTO claimDTO);
	public ClaimDTO getClaimByID(Integer claimID);
	public List<ClaimDTO> getAllClaims();
	public ClaimDTO updateClaim(ClaimDTO claimDTO, Integer claimID);
	public void deleteClaimByID(Integer claimID);
}
