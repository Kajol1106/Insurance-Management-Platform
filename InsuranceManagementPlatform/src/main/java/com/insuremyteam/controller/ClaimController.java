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

import com.insuremyteam.payloads.ClaimDTO;
import com.insuremyteam.service.ClaimService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {

	@Autowired
	private ClaimService claimService;
	
	//create new claim
	@PostMapping()
	public ResponseEntity<ClaimDTO> createNewClaim(@Valid @RequestBody ClaimDTO claimDTO) {
		ClaimDTO newClaim = this.claimService.createClaim(claimDTO);
		return new ResponseEntity<ClaimDTO>(newClaim, HttpStatus.CREATED);
	}
	
	//fetch a specific claim by id
	@GetMapping("/{id}")
	public ResponseEntity<ClaimDTO> getClaimByID(@PathVariable("id") Integer claimID) {
		ClaimDTO claim = this.claimService.getClaimByID(claimID);
		return new ResponseEntity<ClaimDTO>(claim, HttpStatus.OK);
	}
	
	//fetch all claims
	@GetMapping()
	public ResponseEntity<List<ClaimDTO>> getAllClaims() {
		List<ClaimDTO> claims = this.claimService.getAllClaims();
		return new ResponseEntity<List<ClaimDTO>>(claims, HttpStatus.OK);
	}
	
	//update claims's information
	@PutMapping("{id}")
	public ResponseEntity<ClaimDTO> createNewClaim(@RequestBody ClaimDTO claimDTO, @PathVariable("id")Integer claimID) {
		ClaimDTO updatedClaim = this.claimService.updateClaim(claimDTO, claimID);
		return new ResponseEntity<ClaimDTO>(updatedClaim, HttpStatus.ACCEPTED);
	}
	
	//delete claim by id
	@DeleteMapping("{id}")
	public ResponseEntity<?> createNewClaim(@PathVariable("id") Integer claimID) {
		this.claimService.deleteClaimByID(claimID);
		return new ResponseEntity<>(Map.of("Message ", "Claim deleted"), HttpStatus.OK);
	}
	
	
}
