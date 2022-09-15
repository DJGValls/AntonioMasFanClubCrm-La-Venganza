package com.antoniomasfanclub.service;

import com.antoniomasfanclub.model.Account;

import java.util.List;

public interface AccountService {

    List<Account> getAll();
    Account getById(Integer id);
    Account save(Account account);
    Account update(Account account);
    void delete(Integer id);

    Integer getMeanEmployeeCount();
    Integer getMaxEmployeeCount();
    Integer getMinEmployeeCount();

    Integer getMeanOpportunityByAccount();
    Integer getMaxOpportunityByAccount();
    Integer getMinOpportunityByAccount();
}
