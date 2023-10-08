package com.berkay.account.service;

import com.berkay.account.dto.AccountDto;
import com.berkay.account.dto.AccountDtoConverter;
import com.berkay.account.dto.CreateAccountRequest;
import com.berkay.account.model.Account;
import com.berkay.account.model.Customer;
import com.berkay.account.model.Transaction;
import com.berkay.account.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final TransactionService transactionService;
    private final AccountDtoConverter converter;

    public AccountService(AccountRepository accountRepository,
                          CustomerService customerService,
                          TransactionService transactionService, AccountDtoConverter converter)     {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
        this.transactionService = transactionService;
        this.converter = converter;
    }

    public AccountDto createAccount(CreateAccountRequest createAccountRequest)
    {
    Customer customer = customerService.findCustomerById(createAccountRequest.getCustomerId());
    Account account = new Account(createAccountRequest.getInitialCredit(), LocalDateTime.now(),customer);

    if (createAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO)>0)
    {
        Transaction transaction = transactionService.initiateMoney(createAccountRequest.getInitialCredit()
                ,account);
        account.getTransaction().add(transaction);
    }

    return converter.convert(accountRepository.save(account));
    }


}
