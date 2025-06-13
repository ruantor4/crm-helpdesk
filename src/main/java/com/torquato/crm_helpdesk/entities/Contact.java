package com.torquato.crm_helpdesk.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String position; // Ex: Gerente, TI, Comprador

    @ManyToOne
    private Account account;

    @OneToOne
    private User user; // Pode ser opcional — se o contato for também um usuário
}
