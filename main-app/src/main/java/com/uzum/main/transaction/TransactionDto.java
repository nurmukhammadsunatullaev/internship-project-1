package com.uzum.main.transaction;

import com.uzum.main.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {
    private Long id;
    private Long amount;
    private LocalDateTime transactionTime;
    private TransactionStatus transactionStatus;
    private String billingSystem;
}
