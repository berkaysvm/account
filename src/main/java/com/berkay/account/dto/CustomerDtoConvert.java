package com.berkay.account.dto;

import com.berkay.account.model.Customer;

public class CustomerDtoConvert {
    public AccountCustomerDto customerToAccountCustomer(Customer from)
    {
        if (from == null)
        {
            return new AccountCustomerDto("","","");
        }
        return new AccountCustomerDto(from.getId(),from.getName(),from.getSurname());
    }
}
