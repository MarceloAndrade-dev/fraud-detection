package com.example.fraudDetection.service;

import com.example.fraudDetection.model.TransactionEntity;
import com.example.fraudDetection.model.TransactionStatus;
import com.example.fraudDetection.repository.TransactionRepository;
import com.example.fraudDetection.service.rules.FraudRule;
import com.example.fraudDetection.service.rules.VelocityCheckRule;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionAnalysisService {

    private final TransactionRepository repository;
    private final List<FraudRule> rules;

    public TransactionStatus processTransaction(TransactionEntity  transactionEntity) {
        if (repository.existsByTransactionId(transactionEntity.getTransactionId())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Transaction ID already exists");
        }

        transactionEntity.setTimestamp(LocalDateTime.now());

        TransactionStatus finalStatus = rules.stream()
                .map(rule -> rule.validate(transactionEntity))
                .flatMap(Optional::stream)
                .findFirst()
                .orElse(TransactionStatus.APPROVED);

        if (finalStatus == TransactionStatus.APPROVED) {
            rules.stream()
                    .filter(VelocityCheckRule.class::isInstance)
                    .map(VelocityCheckRule.class::cast)
                    .findFirst()
                    .ifPresent(rule -> rule.updateLastTransaction(transactionEntity));
        }

        transactionEntity.setStatus(finalStatus);

        repository.save(transactionEntity);
        return finalStatus;
    }
}