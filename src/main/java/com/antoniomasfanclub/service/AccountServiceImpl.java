package com.antoniomasfanclub.service;

import com.antoniomasfanclub.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;
}
