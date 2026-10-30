package stage.ifm.transactionservice.web.rest;

import org.springframework.web.bind.annotation.*;
import stage.ifm.transactionservice.domain.Transaction;
import stage.ifm.transactionservice.service.TransactionService;

import java.util.List;
import java.util.UUID;

@RestController
public class TransactionRestController {
    private TransactionService transactionService;
    @PostMapping("/transactions")
    public Transaction CreateTransaction(@RequestBody Transaction transaction) {
        return transactionService.createTransaction(transaction);
    }

    @GetMapping("/transactions/{id}")
    public Transaction getTransactionById(@PathVariable UUID id) {
        return transactionService.getTransaction(id);
    }

    @GetMapping("/transactions")
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/transactions/account/{accountId}")
    public List<Transaction> getTransactionByAccount(@PathVariable UUID accountId) {
        return transactionService.getByAccount(accountId);
    }
}
