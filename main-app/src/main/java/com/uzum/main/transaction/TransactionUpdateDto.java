package com.uzum.main.transaction;

import com.uzum.main.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionUpdateDto {
    private TransactionStatus transactionStatus;
}
