package com.example.fraudDetection.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String transactionId;
    @Column(nullable = false)
    private String clientId;
    @Column(nullable = false)
    private BigDecimal amount;
    @Column(nullable = false)
    private LocalDateTime timestamp;
    @Column(nullable = false)
    private String location;
    @Column(nullable = false)
    private String category;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionStatus status;
}