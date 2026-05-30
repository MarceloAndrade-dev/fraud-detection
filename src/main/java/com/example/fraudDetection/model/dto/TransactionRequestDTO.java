package com.example.fraudDetection.model.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequestDTO {
    @NotBlank(message = "TransactionID cannot be blank")
    private String transactionId;
    @NotBlank(message = "ClientID cannot be blank")
    private String clientId;
    @NotNull(message = "Amount cannot be null")
    @Positive(message = "Amount must be greater than zero")
    private BigDecimal amount;
    @NotBlank(message = "Location cannot be blank")
    private String location;
    @NotBlank(message = "Category cannot be blank")
    private String category;
}