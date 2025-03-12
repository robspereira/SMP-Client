package com.smp.client.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.smp.client.model.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientDTO {

    private String name;

    private String cnpj;

    private String email;

    private String address;

    public Client toClient(ClientDTO dto) {
        return Client.builder()
                .name(dto.getName())
                .cnpj(dto.getCnpj())
                .contactEmail(getEmail())
                .address(dto.getAddress())
                .build();
    }

}
