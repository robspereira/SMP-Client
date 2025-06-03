package com.smp.client.queue;

import com.smp.client.DTO.CardRequestDTO;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class MessageSender {

    private SqsTemplate sqsTemplate;

    private final String CARD_REQUEST_QUEUE = "smp-card_create-client-card";


    public void sendCardCreationRequest(CardRequestDTO dto) {
        try {
            sqsTemplate.sendAsync(CARD_REQUEST_QUEUE, dto);
            log.info("Sent request for creating a new card for the client.");
        } catch (Exception e) {
            log.error("Error on card creation request.");
        }
    }

}
