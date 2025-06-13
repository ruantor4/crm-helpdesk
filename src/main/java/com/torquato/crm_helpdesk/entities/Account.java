package com.torquato.crm_helpdesk.entities;

import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
public class Account {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String companyName;
    private String phone;
    private String cpnj; // CNPJ ou CPF
    
     @OneToMany(mappedBy = "account")
    private List<User>users;

    @OneToMany(mappedBy = "account")
    private List<Contact> contacts;
}
