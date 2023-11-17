package com.uzum.main.transaction;

import com.uzum.main.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public TransactionDto add(TransactionDto transactionDto) {
        log.info("POST transaction request received to endpoint [/transactions]");
        return modelMapper.map(transactionRepository.save(
                modelMapper.map(transactionDto, Transaction.class)), TransactionDto.class);
    }

    @Override
    @Transactional
    public TransactionDto update(Long transactionId, TransactionUpdateDto transactionDto) {
        log.info("PATCH transaction request received to endpoint [/transactions]");
        Transaction transaction = transactionRepository.findById(transactionId).orElseThrow(() -> {
            log.error("Transaction not found for id = {}", transactionId);
            return new NotFoundException(String.format("Transaction not found for id = %d", transactionId));
        });
        transaction.setTransactionStatus(transactionDto.getTransactionStatus());
        transactionRepository.save(transaction);
        return modelMapper.map(transactionRepository.findById(transactionId).get(), TransactionDto.class);
    }

    @Override
    @Transactional(readOnly = true)
    public TransactionDto get(Long transactionId) {
        log.info("GET transaction request received to endpoint [/transactions]");
        Transaction transaction = transactionRepository.findById(transactionId).orElseThrow(() -> {
            log.error("Transaction not found for id = {}", transactionId);
            return new NotFoundException(String.format("Transaction not found for id = %d", transactionId));
        });
        return modelMapper.map(transaction, TransactionDto.class);
    }

    @Override
    @Transactional
    public void delete(Long transactionId) {
        log.info("DELETE transaction request received to endpoint [/transactions]");
        transactionRepository.deleteById(transactionId);
    }
}
