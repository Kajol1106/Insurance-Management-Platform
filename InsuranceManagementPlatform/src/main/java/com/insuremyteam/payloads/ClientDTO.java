package com.insuremyteam.payloads;

import java.util.Date;

import com.insuremyteam.model.ContactInformation;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClientDTO {
	
	private Integer cliendId;
	
	private String name;
	
	//@Past
	private String dateOfBirth;
	
	private String address;
	
	@Enumerated(EnumType.STRING)
	private ContactInformation contact;
}
