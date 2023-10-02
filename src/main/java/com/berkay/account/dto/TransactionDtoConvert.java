package com.berkay.account.dto;

import com.berkay.account.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionDtoConvert {

    public TransactionDto convert(Transaction from)
    {
        return new TransactionDto(from.getId(),
                from.getTransactionType(),
                from.getAmount(),
                from.getTransactionDate());
    }
}
