package com.example.LibraryManagementApplication.services;

import com.example.LibraryManagementApplication.dtos.ClientDto;
import com.example.LibraryManagementApplication.exceptions.ExistsCpfException;
import com.example.LibraryManagementApplication.model.Client;
import com.example.LibraryManagementApplication.repositories.ClientRepository;
import com.example.LibraryManagementApplication.validators.ExistsClientValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final ExistsClientValidator existsClientValidator;

    public ClientService(ClientRepository clientRepository, ExistsClientValidator existsClientValidator) {
        this.clientRepository = clientRepository;
        this.existsClientValidator = existsClientValidator;
    }

    public Client create(ClientDto input) {
        Client client = new Client(input.getName(), input.getCpf());
        if (this.clientRepository.existsByCpf(input.getCpf())) {
            throw new ExistsCpfException();
        }
        return this.clientRepository.save(client);
    }

    public Client find(Long clientId) {
        return this.existsClientValidator.validateById(clientId);
    }

    public List<Client> findAll() {
        return this.clientRepository.findAll();
    }

    public Client update(ClientDto input, Long clientId) {
        Client client = this.existsClientValidator.validateById(clientId);
        client.setCpf(input.getCpf());
        client.setName(input.getName());
        return this.clientRepository.save(client);
    }

    public void delete(Long clientId) {
        this.existsClientValidator.validateById(clientId);
        this.clientRepository.deleteById(clientId);
    }
}
