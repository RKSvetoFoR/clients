package ru.mrsu.test.project.clients.controller;

import ru.mrsu.test.project.clients.service.Client;
import ru.mrsu.test.project.clients.service.ClientService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @GetMapping("internal/clients")
    public List<Client> getClient() {
        return clientService.getClients();
    }
}
