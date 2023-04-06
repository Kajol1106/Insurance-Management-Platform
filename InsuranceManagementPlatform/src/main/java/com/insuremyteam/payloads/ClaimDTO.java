package com.insuremyteam.payloads;

import java.util.Date;

import com.insuremyteam.model.ClaimStatus;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClaimDTO {
	private Integer claimNumber;
	private String description;
	private String claimDate;
	@Enumerated(EnumType.STRING)
	private ClaimStatus claimStatus;
}
