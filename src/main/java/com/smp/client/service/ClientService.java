package com.smp.client.service;

import com.smp.client.DTO.ClientRequestDTO;
import com.smp.client.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientService {

    private final ClientRepository repository;


    public void saveClient(ClientRequestDTO dto) {

    }

}
