package com.insuremyteam.service.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insuremyteam.exception.ResourceNotFoundException;
import com.insuremyteam.model.Client;
import com.insuremyteam.payloads.ClientDTO;
import com.insuremyteam.repository.ClientRepository;
import com.insuremyteam.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository clientRepo;
	
	@Autowired
	private ModelMapper modleMapper;

	@Override
	public ClientDTO registerUser(ClientDTO clientDTO) {
		Client client = this.modleMapper.map(clientDTO, Client.class);
		Client registeredClient = this.clientRepo.save(client);
		return this.modleMapper.map(registeredClient, ClientDTO.class);
	}

	@Override
	public ClientDTO getClientByID(Integer clientID) {
		Client client = this.clientRepo.findById(clientID)
				.orElseThrow(()-> new ResourceNotFoundException("Client ", "Client ID ", clientID));
		return this.modleMapper.map(client, ClientDTO.class);
	}

	@Override
	public List<ClientDTO> getAllClients() {
		List<Client> clients = this.clientRepo.findAll();
		List<ClientDTO> allClients = clients.stream()
				.map(client -> this.modleMapper.map(client, ClientDTO.class)).collect(Collectors.toList());
		return allClients;
	}

	@Override
	public ClientDTO updateClient(ClientDTO clientDTO, Integer clientID) {
		Client client = this.clientRepo.findById(clientID)
				.orElseThrow(()-> new ResourceNotFoundException("Client ", "Client ID ", clientID));
		client.setAddress(clientDTO.getAddress());
		client.setContact(clientDTO.getContact());
		client.setDateOfBirth(clientDTO.getDateOfBirth());
		client.setName(clientDTO.getName());
		
		Client updatedClient = this.clientRepo.save(client);
		return this.modleMapper.map(updatedClient, ClientDTO.class);
	}

	@Override
	public void deleteClientByID(Integer clientID) {
		Client client = this.clientRepo.findById(clientID)
				.orElseThrow(()-> new ResourceNotFoundException("Client ", "Client ID ", clientID));
		this.clientRepo.delete(client);
	}

}
