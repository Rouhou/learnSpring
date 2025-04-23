package com.learn.learn.controller;

import com.learn.learn.DTO.ErrorEntity;
import com.learn.learn.entite.Client;
import com.learn.learn.service.ClientService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
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

//    Error Handling Method 1
//    @ResponseStatus(value = HttpStatus.OK)
//    @GetMapping(path="{id}", produces = APPLICATION_JSON_VALUE)
//    public ResponseEntity getDataById(@PathVariable int id) {
//        try{
//            return ResponseEntity.ok(this.clientService.getDataById(id));
//        }catch(EntityNotFoundException e){
//            return ResponseEntity.status(BAD_REQUEST).body(new ErrorEntity(null, e.getMessage()));
//        }
//    }

//    Error Handling Method 2 et 3 (tronc commun)
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(path="{id}", produces = APPLICATION_JSON_VALUE)
    public Client getDataById(@PathVariable int id) {
        return this.clientService.getDataById(id);
    }

//   Error Handling Method 2 suite
//    @ResponseStatus(BAD_REQUEST)
//    @ExceptionHandler({EntityNotFoundException.class})
//    public ErrorEntity handleException(EntityNotFoundException e){
//        return new ErrorEntity(null, e.getMessage());
//    }


    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @PutMapping(path = "{id}", consumes = APPLICATION_JSON_VALUE)
    public void updateClient(@PathVariable int id, @RequestBody Client client){
        this.clientService.updateService(id, client);
    }
}
