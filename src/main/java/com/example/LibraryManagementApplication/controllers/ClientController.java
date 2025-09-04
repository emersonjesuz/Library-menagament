package com.example.LibraryManagementApplication.controllers;

import com.example.LibraryManagementApplication.dtos.ClientDto;
import com.example.LibraryManagementApplication.model.Client;
import com.example.LibraryManagementApplication.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/client")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping()
    public Client create(@RequestBody @Valid ClientDto body) {
        return this.clientService.create(body);
    }

    @GetMapping(path = "/{clientId}")
    public Client find(@PathVariable Long clientId) {
        return this.clientService.find(clientId);
    }

    @GetMapping()
    public List<Client> findAll() {
        return this.clientService.findAll();
    }

    @PutMapping(path = "/{clientId}")
    public Client update(@RequestBody @Valid ClientDto client, @PathVariable Long clientId) {
        return this.clientService.update(client, clientId);
    }

    @DeleteMapping(path = "/{clientId}")
    public void delete(@PathVariable Long clientId) {
        this.clientService.delete(clientId);
    }
}
