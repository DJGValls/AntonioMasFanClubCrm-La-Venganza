package com.antoniomasfanclub.service;

import com.antoniomasfanclub.model.Account;
import com.antoniomasfanclub.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<Account> getAll() {
        return this.accountRepository.findAll();
    }

    @Override
    public Account getById(Integer id) {
        return this.accountRepository.getAccountById(id);
    }

    @Override
    public Account save(Account account) {
        return this.accountRepository.save(account);
    }

    @Override
    public Account update(Account account) {
        return this.accountRepository.save(account);
    }

    @Override
    public void delete(Integer id) {
        this.accountRepository.delete(this.accountRepository.getAccountById(id));
    }

    @Override
    public Integer getMeanEmployeeCount() {
        return this.accountRepository.getMeanEmployeeCount();
    }

    @Override
    public Integer getMaxEmployeeCount() {
        return this.accountRepository.getMaxEmployeeCount();
    }

    @Override
    public Integer getMinEmployeeCount() {
        return this.accountRepository.getMinEmployeeCount();
    }

    @Override
    public Integer getMeanOpportunityByAccount() {
        return this.accountRepository.getMeanOpportunityByAccount();
    }

    @Override
    public Integer getMaxOpportunityByAccount() {
        return this.accountRepository.getMaxOpportunityByAccount();
    }

    @Override
    public Integer getMinOpportunityByAccount() {
        return this.accountRepository.getMinOpportunityByAccount();
    }
}
