package com.example.fraudDetection.model.dto;

import com.example.fraudDetection.model.TransactionStatus;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReceiptResponseDTO {
    private String transactionId;
    private TransactionStatus status;
}