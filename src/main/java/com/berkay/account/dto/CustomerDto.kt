package com.berkay.account.dto

import com.berkay.account.model.Account

data class CustomerDto(
        val id: String,
        val name: String,
        val surname: String,
        val account: Set<CustomerAccountDto>
)
