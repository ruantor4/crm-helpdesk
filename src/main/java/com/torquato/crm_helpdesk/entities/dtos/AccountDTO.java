package com.torquato.crm_helpdesk.entities.dtos;

import com.torquato.crm_helpdesk.entities.Account;

import lombok.Data;

@Data
public class AccountDTO {
    
    private Long id;
    private String companyName;
    private String phone;
    private String cnpj;

    public AccountDTO(Account account){
        this.id = account.getId();
        this.companyName = account.getCompanyName();
        this.phone = account.getPhone();
        this.cnpj = account.getCnpj();
    }
}
