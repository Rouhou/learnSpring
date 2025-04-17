package com.learn.learn.service;

import com.learn.learn.entite.Client;
import com.learn.learn.reporitory.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void create(Client client) {
        Client myClient = clientRepository.findByEmail(client.getEmail());
        if(myClient == null) {
            this.clientRepository.save(client);
        }
    }

    public List<Client> getData(){
        return this.clientRepository.findAll();
    }

    public Client getDataById(int id) {
        Optional<Client> optionalClient = this.clientRepository.findById(id);

//        First Method
//        if(optionalClient.isPresent()) {
//            return optionalClient.get();
//        }
//        return null;

//        Second Method
        return optionalClient.orElse(null);
    }

    public Client getOrCreate(Client clientToCreate) {
        Client myClient = clientRepository.findByEmail(clientToCreate.getEmail());
        if(myClient == null) {
            this.clientRepository.save(clientToCreate);
        }
        return clientToCreate;
    }

    public void updateService(int id, Client client) {
        Client myClient = this.getDataById(id);

        if(myClient.getId() == client.getId()) {
            myClient.setEmail(client.getEmail());
            myClient.setTelephone(client.getTelephone());
            this.clientRepository.save(myClient);
        }
    }
}
