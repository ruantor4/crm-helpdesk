package com.torquato.crm_helpdesk.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class TroubleTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rootCause;

    @Column(columnDefinition = "TEXT")
    private String solution;

    @ManyToOne
    private User createdBy;

    @ManyToOne
    private User resolvedBy;

    @Column(nullable = false)
    private LocalDateTime createdDate;

    @OneToOne
    private Ticket ticket;

    @OneToMany(mappedBy = "troubleTicket", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

    @OneToMany(mappedBy = "troubleTicket", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Attachment> attachments;

    
}
