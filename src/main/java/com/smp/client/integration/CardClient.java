package com.smp.client.integration;

import com.smp.client.DTO.CardInformationDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "CardClient", url = "http://localhost:9981")
public interface CardClient {

    @GetMapping(path = "/cards")
    CardInformationDTO getClientCardInformation(@RequestParam final Long clientId);
}
