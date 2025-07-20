package com.smp.client.controller;

import com.smp.client.DTO.CardInformationDTO;
import com.smp.client.DTO.ClientDTO;
import com.smp.client.model.Client;
import com.smp.client.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {

    private final ClientService service;

    @PostMapping(value = "/new")
    public ResponseEntity<Client> createClient(ClientDTO client){
        return ResponseEntity.ok(service.saveClient(client));
    }

    @GetMapping
    public ResponseEntity<Client> findClientByDocumentNumber(@RequestParam("documentNumber") final String documentNumber){
        return ResponseEntity.ok(service.findByDocumentNumber(documentNumber));
    }

    @DeleteMapping(value = "/delete/cnpj/{cnpj}")
    public ResponseEntity<Void> deleteClient(@PathVariable("cnpj") final String cnpj){
        service.deleteClientByCnpj(cnpj);
        return ResponseEntity.accepted().build();
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Void> updateClient(@RequestBody final ClientDTO client){
        service.updateClient(client);
        return ResponseEntity.accepted().build();
    }

    @GetMapping(value = "/cardInfo")
    public ResponseEntity<CardInformationDTO> getClientCardInfo(@RequestParam final Long clientId){
        return ResponseEntity.ok(service.getClientCardInformation(clientId));
    }
}
