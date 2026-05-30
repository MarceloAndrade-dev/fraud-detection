package com.example.fraudDetection.service.rules;

import com.example.fraudDetection.model.TransactionEntity;
import com.example.fraudDetection.model.TransactionStatus;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Optional;

@Component
public class VelocityCheckRule implements FraudRule {

    // Cache em memória para guardar a última transação de cada cliente
    private final Map<String, TransactionEntity> lastTransactionCache = new ConcurrentHashMap<>();

    @Override
    public Optional<TransactionStatus> validate(TransactionEntity currentTransaction) {
        TransactionEntity lastTransaction = lastTransactionCache.get(currentTransaction.getClientId());

        if (lastTransaction != null) {
            Duration duration = Duration.between(lastTransaction.getTimestamp(), currentTransaction.getTimestamp());

            if (duration.toSeconds() < 5) {
                return Optional.of(TransactionStatus.REJECTED_HIGH_FREQUENCY);
            }
        }

        return Optional.empty();
    }

    public void updateLastTransaction(TransactionEntity transaction) {
        lastTransactionCache.put(transaction.getClientId(), transaction);
    }
}