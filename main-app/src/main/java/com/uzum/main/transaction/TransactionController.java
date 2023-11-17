package com.uzum.main.transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping
    public TransactionDto addNewItem(@RequestBody TransactionDto transactionDto) {
        return transactionService.add(transactionDto);
    }

    @PatchMapping("/{id}")
    public TransactionDto updateItem(@PathVariable("id") Long transactionId,
                                     @RequestBody TransactionUpdateDto transactionDto) {
        return transactionService.update(transactionId, transactionDto);
    }

    @GetMapping("/{id}")
    public TransactionDto getById(@PathVariable("id") Long transactionId) {
        return transactionService.get(transactionId);
    }

    @DeleteMapping("/{id}")
    public void updateItem(@PathVariable("id") Long transactionId) {
        transactionService.delete(transactionId);
    }
}
