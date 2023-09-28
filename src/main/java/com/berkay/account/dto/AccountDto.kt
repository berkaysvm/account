package com.berkay.account.dto

import com.berkay.account.model.Customer
import com.berkay.account.model.Transaction
import java.math.BigDecimal
import java.time.LocalDateTime

data class AccountDto (
        val id: String?,
        val balance: BigDecimal?,
        val creationDate: LocalDateTime?,
        val customer: CustomerDto?,
        val transactions: Set<TransactionDto>?
        ){
}