package com.crm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Transaction {
    private String transactionId;
    private String userEmail;
    private double amount;
    private int orderId;
}
