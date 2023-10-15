package com.berkay.account.service;

import com.berkay.account.model.Account;
import com.berkay.account.model.Transaction;
import com.berkay.account.repository.TransactionRepository;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransactionService {
    private Logger logger = LoggerFactory.getLogger(TransactionService.class);

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    protected Transaction initiateMoney( BigDecimal amount, final Account account)
    {
        return transactionRepository.save(new Transaction(amount,account));
    }
}
