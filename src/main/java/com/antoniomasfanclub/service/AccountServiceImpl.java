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
        return this.accountRepository.getReferenceById(id);
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
        this.accountRepository.delete(this.accountRepository.getReferenceById(id));
    }
}
