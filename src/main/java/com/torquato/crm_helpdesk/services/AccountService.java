package com.torquato.crm_helpdesk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.torquato.crm_helpdesk.entities.Account;
import com.torquato.crm_helpdesk.exceptions.ObjectNotFoundException;
import com.torquato.crm_helpdesk.repositories.AccountRepository;

@Service
public class AccountService {
    
    @Autowired
    private AccountRepository accountRepository;

    public List<Account> findAll(){
        return accountRepository.findAll();
    }

    public Account findById(Long id){
        return accountRepository.findById(id)
        .orElseThrow(() -> new ObjectNotFoundException("Conta com ID " + id + " não encontrado.",id));
    }

    public Account createAccount(Account account){
        return accountRepository.save(account);   
    }
}
