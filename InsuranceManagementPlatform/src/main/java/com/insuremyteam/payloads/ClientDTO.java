package com.insuremyteam.payloads;

import com.insuremyteam.model.ContactInformation;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClientDTO {
	
	private Integer cliendId;
	
	@Pattern(regexp = "[A-Z][a-z]*", message = "name should start with capital letter")
	private String name;
	
	@Pattern(regexp = "dd-mm-yyyy", message = "Please provice date of birth format dd-mm-yyyy in this way")
	private String dateOfBirth;
	
	private String address;
	
	@Enumerated(EnumType.STRING)
	private ContactInformation contact;
}
