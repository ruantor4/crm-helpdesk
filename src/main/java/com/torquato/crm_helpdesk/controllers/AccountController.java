package com.torquato.crm_helpdesk.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.torquato.crm_helpdesk.entities.Account;
import com.torquato.crm_helpdesk.entities.dtos.AccountDTO;
import com.torquato.crm_helpdesk.services.AccountService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;
    
    @GetMapping
    public ResponseEntity<List<AccountDTO>> findAll(){
        List<AccountDTO> accounts = accountService.findAll()
        .stream()
        .map(AccountDTO::new)
        .toList();
        return ResponseEntity.ok(accounts);
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> findById(@PathVariable Long id){
            Account account = accountService.findById(id);
            return ResponseEntity.ok(new AccountDTO(account));
       
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account newAccount = accountService.createAccount(account);
        return ResponseEntity.ok().body(newAccount);
    }
    

}
