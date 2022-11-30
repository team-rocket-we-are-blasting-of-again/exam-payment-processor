package com.crm.service;

import com.crm.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @KafkaListener(id = "payment-processor-valid", topics = "valid-transaction")
    @KafkaHandler
    public void validPayments(@Payload Transaction transaction) {
        System.out.println("VALID");
        System.out.println(transaction.toString());
        simpMessagingTemplate.convertAndSend("/payment/valid", transaction);
    }
    @KafkaListener(id = "payment-processor-invalid", topics = "invalid-transaction")
    @KafkaHandler
    public void invalidPayments(@Payload Transaction transaction) {
        System.out.println("INVALID");

        System.out.println(transaction.toString());

        simpMessagingTemplate.convertAndSend("/payment/invalid", transaction);
    }
}
