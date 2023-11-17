package com.uzum.main.transaction;

public interface TransactionService {
    TransactionDto add(TransactionDto transactionDto);

    TransactionDto update(Long transactionId, TransactionUpdateDto transactionDto);

    TransactionDto get(Long transactionId);

    void delete(Long transactionId);
}
