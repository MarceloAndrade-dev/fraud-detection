package com.example.fraudDetection.service.rules;

import com.example.fraudDetection.model.TransactionEntity;
import com.example.fraudDetection.model.TransactionStatus;

import java.util.Optional;

public interface FraudRule {
    /**
     * Avalia uma transação contra uma regra específica de fraude.
     * @return Optional.empty() se passar na regra, ou o status de rejeição se for fraude.
     */
    Optional<TransactionStatus> validate(TransactionEntity transaction);
}