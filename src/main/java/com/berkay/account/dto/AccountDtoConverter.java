package com.berkay.account.dto;

import com.berkay.account.model.Account;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class AccountDtoConverter {

    private final CustomerDtoConvert customerDtoConvert;
    private final TransactionDtoConvert transactionDtoConvert;

    public AccountDtoConverter(CustomerDtoConvert customerDtoConvert, TransactionDtoConvert transactionDtoConvert) {
        this.customerDtoConvert = customerDtoConvert;
        this.transactionDtoConvert = transactionDtoConvert;
    }

    public AccountDto convert(Account from)
    {
        return new AccountDto(from.getId(),
                from.getBalance(),
                from.getCreationDate(),
                customerDtoConvert.customerToAccountCustomer(from.getCustomer()),
                from.getTransaction()
                        .stream()
                        .map(transactionDtoConvert::convert)
                        .collect(Collectors.toSet()));
    }
}
