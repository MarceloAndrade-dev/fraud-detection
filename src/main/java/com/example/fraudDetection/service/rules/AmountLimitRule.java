package com.example.fraudDetection.service.rules;

import com.example.fraudDetection.model.TransactionEntity;
import com.example.fraudDetection.model.TransactionStatus;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
public class AmountLimitRule implements FraudRule {

    private static final BigDecimal AMOUNT_LIMIT = new BigDecimal("10000");

    @Override
    public Optional<TransactionStatus> validate(TransactionEntity transaction) {
        if (transaction.getAmount().compareTo(AMOUNT_LIMIT) > 0){
            return Optional.of(TransactionStatus.REJECTED_HIGH_AMOUNT);
        }

        return Optional.empty();
    }
}