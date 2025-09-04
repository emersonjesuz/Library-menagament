package com.example.LibraryManagementApplication.validators;

import com.example.LibraryManagementApplication.exceptions.ClientNotFoundError;
import com.example.LibraryManagementApplication.model.Client;
import com.example.LibraryManagementApplication.repositories.ClientRepository;
import org.springframework.stereotype.Component;

@Component
public class ExistsClientValidator {
    private final ClientRepository clientRepository;

    public ExistsClientValidator(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client validateById(Long clientId) {
        return this.clientRepository.findById(clientId).orElseThrow(ClientNotFoundError::new);
    }
}
