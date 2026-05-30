package com.example.fraudDetection.repository;

import com.example.fraudDetection.model.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
    // O Spring Data JPA vai gerar automaticamente os métodos de Save e Find aqui
    boolean existsByTransactionId(String transactionId);
}