package com.example.fraudDetection.controller;

import com.example.fraudDetection.mapper.TransactionMapper;
import com.example.fraudDetection.model.TransactionEntity;
import com.example.fraudDetection.model.TransactionStatus;
import com.example.fraudDetection.model.dto.ReceiptResponseDTO;
import com.example.fraudDetection.model.dto.TransactionRequestDTO;
import com.example.fraudDetection.service.TransactionAnalysisService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionAnalysisService analysisService;
    private final TransactionMapper transactionMapper;

    @PostMapping
    public ResponseEntity<ReceiptResponseDTO> createTransaction(@Valid @RequestBody TransactionRequestDTO request) {
        TransactionEntity transactionEntity = transactionMapper.toEntity(request);
        TransactionStatus finalStatus = analysisService.processTransaction(transactionEntity);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ReceiptResponseDTO(request.getTransactionId(), finalStatus));
    }
}