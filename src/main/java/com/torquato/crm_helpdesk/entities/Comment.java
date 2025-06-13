package com.torquato.crm_helpdesk.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String text;

    @ManyToOne
    private User createdBy;

    @ManyToOne
    private User resolvedBy; // Opcional — usado se o comentário for de resolução.

    @ManyToOne
    private TroubleTicket troubleTicket;

    private LocalDateTime resolvedAt;
    
}
