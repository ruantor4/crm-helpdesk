package com.torquato.crm_helpdesk.entities;

import java.time.LocalDateTime;

import com.torquato.crm_helpdesk.entities.enums.PriorityStatus;
import com.torquato.crm_helpdesk.entities.enums.TicketStatus;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private TicketStatus status;

    @Enumerated(EnumType.STRING)
    private PriorityStatus priority;

    @ManyToOne
    private User createdBy;

    @ManyToOne
    private User assignedTo;

    @ManyToOne
    private Contact contact;

    private LocalDateTime createdTime;
    private LocalDateTime modifiedTime;
}
