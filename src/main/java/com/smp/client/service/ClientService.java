package com.smp.client.service;

import com.smp.client.DTO.ClientDTO;
import com.smp.client.exception.ClientAlreadyExistsException;
import com.smp.client.exception.ClientNotFoundException;
import com.smp.client.model.Client;
import com.smp.client.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientService {

    private final ClientRepository repository;


    public Client saveClient(ClientDTO dto) {
        repository.findByCnpj(dto.getCnpj()).ifPresent(client -> {
            throw new ClientAlreadyExistsException("CNPJ já existe no banco de dados");
        });

        return repository.save(dto.toClient(dto));
    }

    public Client findByCnpj(String cnpj) {
        return repository.findByCnpj(cnpj)
                .orElseThrow(() -> new ClientNotFoundException("Cliente não encontrado pelo CNPJ informado"));
    }

    public void deleteClientByCnpj(String cnpj) {
        Client clientToDelete = findByCnpj(cnpj);

        repository.delete(clientToDelete);
    }

    public void updateClient(ClientDTO dto) {
        Client update = findByCnpj(dto.getCnpj());

        update.setName(dto.getName());
        update.setContactEmail(dto.getEmail());
        update.setAddress(update.getAddress());

        repository.save(update);
    }

}
