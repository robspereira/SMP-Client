package com.smp.client.service;

import com.smp.client.DTO.CardInformationDTO;
import com.smp.client.DTO.ClientDTO;
import com.smp.client.exception.ClientAlreadyExistsException;
import com.smp.client.exception.ClientNotFoundException;
import com.smp.client.integration.CardClient;
import com.smp.client.model.Client;
import com.smp.client.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientService {

    private final ClientRepository repository;
    private final QueueProcessService queueService;
    private final CardClient cardClient;


    public Client saveClient(ClientDTO dto) {
        repository.findByDocumentNumber(dto.getDocumentNumber()).ifPresent(client -> {
            throw new ClientAlreadyExistsException("Cliente já existe no banco de dados");
        });

        Client savedClient = repository.save(dto.toClient(dto));

        requestCardCreationForClient(savedClient);

        return savedClient;
    }

    public Client findByDocumentNumber(String cnpj) {
        return repository.findByDocumentNumber(cnpj)
                .orElseThrow(() -> new ClientNotFoundException("Cliente não encontrado pelo número de documento informado"));
    }

    public void deleteClientByCnpj(String cnpj) {
        Client clientToDelete = findByDocumentNumber(cnpj);

        repository.delete(clientToDelete);
    }

    public void updateClient(ClientDTO dto) {
        Client update = findByDocumentNumber(dto.getDocumentNumber());

        update.setName(dto.getName());
        update.setContactEmail(dto.getEmail());

        repository.save(update);
    }

    private void requestCardCreationForClient(Client client) {
        queueService.sendCardCreationRequest(client);

    }

    public CardInformationDTO getClientCardInformation(Long clientId) {
        return cardClient.getClientCardInformation(clientId);
    }

}
