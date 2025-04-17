package com.learn.learn.controller;

import com.learn.learn.entite.Client;
import com.learn.learn.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "client")
public class ClientController {
    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody Client client) {
        this.clientService.create(client);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Client> getData(){
        return this.clientService.getData();
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(path="{id}", produces = APPLICATION_JSON_VALUE)
    public Client getDataById(@PathVariable int id) {
        return this.clientService.getDataById(id);
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @PutMapping(path = "{id}", consumes = APPLICATION_JSON_VALUE)
    public void updateClient(@PathVariable int id, @RequestBody Client client){
        this.clientService.updateService(id, client);
    }
}
