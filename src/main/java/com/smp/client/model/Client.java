package com.smp.client.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CLIENT")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLIENT_ID")
    private Long clientId;

    @Column(nullable = false, unique = true, name = "CNPJ")
    private String cnpj;

    @Column(nullable = false, name = "CLIENT_NAME")
    private String name;

    @Column(nullable = false, unique = true, name = "CONTACT_EMAIL")
    private String contactEmail;

    @Column(nullable = false, unique = true)
    private String address;


}
