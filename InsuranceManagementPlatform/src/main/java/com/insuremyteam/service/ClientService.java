package com.insuremyteam.service;

import java.util.List;

import com.insuremyteam.payloads.ClientDTO;

public interface ClientService {
	public ClientDTO registerUser(ClientDTO clientDTO);
	public ClientDTO getClientByID(Integer clientID);
	public List<ClientDTO> getAllClients();
	public ClientDTO updateClient(ClientDTO clientDTO, Integer clientID);
	public void deleteClientByID(Integer clientID);
}
