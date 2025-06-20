package com.torquato.crm_helpdesk.entities;

import java.util.List;

import com.torquato.crm_helpdesk.entities.enums.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_user")
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

    @OneToMany(mappedBy = "user")
    private List<Contact> contacts;
    
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany(mappedBy = "createdBy")
    private List<Ticket> createdTickets;

    @OneToMany(mappedBy = "assignedTo")
    private List<Ticket> assignedTickets;

    @OneToMany(mappedBy = "createdBy")
    private List<TroubleTicket> createdTroubles;

    @OneToMany(mappedBy = "resolvedBy")
    private List<TroubleTicket> resolvedTroubles;

    @OneToMany(mappedBy = "createdBy")
    private List<Comment> comments;
    
}
