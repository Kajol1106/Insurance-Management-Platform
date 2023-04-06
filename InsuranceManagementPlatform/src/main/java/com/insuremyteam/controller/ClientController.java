package com.insuremyteam.controller;

import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Response;
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

import com.insuremyteam.payloads.ClientDTO;
import com.insuremyteam.service.ClientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/clients")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	//create new Client
	@PostMapping()
	public ResponseEntity<ClientDTO> registerClient(@Valid @RequestBody ClientDTO clientDTO) {
		ClientDTO registeredClient = this.clientService.registerUser(clientDTO);
		return new ResponseEntity<ClientDTO>(registeredClient, HttpStatus.CREATED);
	}
	
	//Fetch a specific client by ID
	@GetMapping("/{id}")
	public ResponseEntity<ClientDTO> getClientByID(@PathVariable("id") Integer clientID) {
		ClientDTO client = this.clientService.getClientByID(clientID);
		return new ResponseEntity<ClientDTO>(client, HttpStatus.OK);
	}
	
	//fetch all clients
	@GetMapping()
	public ResponseEntity<List<ClientDTO>> getAllClients() {
		List<ClientDTO> allClients = this.clientService.getAllClients();
		return new ResponseEntity<List<ClientDTO>>(allClients, HttpStatus.OK);
	}
	
	//update a clients's information
	@PutMapping("/{id}")
	public ResponseEntity<ClientDTO> updateClient(@RequestBody ClientDTO clientDTO, @PathVariable("id") Integer clientID) {
		ClientDTO updatedClient = this.clientService.updateClient(clientDTO, clientID);
		return new ResponseEntity<ClientDTO>(updatedClient, HttpStatus.ACCEPTED);
	}
	
	//delete a client
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteClientByID(@PathVariable("id") Integer clientID) {
		this.clientService.deleteClientByID(clientID);
		return new ResponseEntity<>(Map.of("Message ", "Client deleted"), HttpStatus.OK);
	}

}
