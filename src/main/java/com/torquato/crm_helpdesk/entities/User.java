package com.torquato.crm_helpdesk.entities;

import com.torquato.crm_helpdesk.entities.enums.Role;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private Boolean status;

    @Enumerated(EnumType.STRING)
    private Role role; // ADMIN, TECHNICIAN, CUSTOMER, CONTACT

    @ManyToOne
    private Account account;
}
