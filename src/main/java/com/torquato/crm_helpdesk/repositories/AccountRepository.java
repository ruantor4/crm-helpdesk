package com.torquato.crm_helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.torquato.crm_helpdesk.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    
}
