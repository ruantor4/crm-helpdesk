package com.torquato.crm_helpdesk.exceptions;

public class ObjectNotFoundException extends RuntimeException {
    
    private Long id;

    public ObjectNotFoundException(String message, Long id){
        super(message);
        this.id = id;
    }
    
    public Long getId() {
        return id;
    }
}
