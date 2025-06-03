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
@Table(name = "COMPANY")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY.IDENTITY)
    @Column(name = "COMPANY_ID")
    private Long id;

    @Column(nullable = false, name = "COMPANY_NAME")
    private String name;

    @Column(nullable = false, name = "COMPANY_CODE")
    private String code;

    @Column(name = "COMPANY_EMAIL")
    private String companyEmail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLIENT_ID", nullable = false)
    private Client client;

}