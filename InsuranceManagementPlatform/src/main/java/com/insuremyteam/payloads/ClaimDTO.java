package com.insuremyteam.payloads;

import com.insuremyteam.model.ClaimStatus;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClaimDTO {
	private Integer claimNumber;
	
	private String description;
	
	@Pattern(regexp = "dd-mm-yyyy", message = "Please provice date format dd-mm-yyyy in this way")
	private String claimDate;
	
	@Enumerated(EnumType.STRING)
	private ClaimStatus claimStatus;
}
