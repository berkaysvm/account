package com.berkay.account.service;

import com.berkay.account.dto.AccountDto;
import com.berkay.account.dto.CreateAccountRequest;
import com.berkay.account.model.Account;
import com.berkay.account.model.Customer;
import com.berkay.account.model.Transaction;
import com.berkay.account.repository.AccountRepository;
import com.berkay.account.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerService customerService;

    public AccountService(AccountRepository accountRepository, CustomerService customerService) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
    }

    public AccountDto createAccount(CreateAccountRequest createAccountRequest)
    {
    Customer customer = customerService.findCustomerById(createAccountRequest.getCustomerId());
    Account account = new Account(createAccountRequest.getInitialCredit(), LocalDateTime.now(),customer);

    if (createAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO)>0)
    {
        //Transaction transaction = TransactionService.createTransaction();
    }
    }


}
