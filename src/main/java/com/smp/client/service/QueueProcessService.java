package com.smp.client.service;

import com.smp.client.DTO.CardRequestDTO;
import com.smp.client.model.Client;
import com.smp.client.model.Company;
import com.smp.client.queue.MessageSender;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class QueueProcessService {

    private final CompanyService service;

    private final MessageSender sender;

    public void sendCardCreationRequest(Client clientInfo) {
        Company companyToLink = service.getRandomCompany();

        sender.sendCardCreationRequest(
                CardRequestDTO.builder()
                        .clientId(clientInfo.getClientId())
                        .clientName(clientInfo.getName())
                        .clientDocumentNumber(clientInfo.getDocumentNumber())
                        .companyId(companyToLink.getId())
                        .companyName(companyToLink.getName())
                .build());

    }
}
