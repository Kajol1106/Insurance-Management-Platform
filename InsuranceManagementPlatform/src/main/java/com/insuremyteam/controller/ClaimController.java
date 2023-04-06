package com.insuremyteam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping("/claim")
	public ResponseEntity<ClaimDTO> createNewClaim(@Valid @RequestBody ClaimDTO claimDTO) {
		ClaimDTO newClaim = this.claimService.createClaim(claimDTO);
		return new ResponseEntity<ClaimDTO>(newClaim, HttpStatus.CREATED);
	}
}
