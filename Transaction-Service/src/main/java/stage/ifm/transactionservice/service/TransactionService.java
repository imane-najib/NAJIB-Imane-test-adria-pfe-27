package stage.ifm.transactionservice.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stage.ifm.transactionservice.domain.AccountDTO;
import stage.ifm.transactionservice.domain.AccountFeignClient;
import stage.ifm.transactionservice.domain.Transaction;
import stage.ifm.transactionservice.repository.TransactionRepository;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class TransactionService {

    private TransactionRepository transactionRepository;

    private AccountFeignClient accountFeignClient;


    public Transaction createTransaction(Transaction transaction) {


        if (transaction.getAmount() == null || transaction.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(
                    "Le montant doit être positif"
            );
        }

        AccountDTO account = accountFeignClient.getAccount(transaction.getAccountId());


        if (!"ACTIVE".equals(account.status())) {
            throw new RuntimeException("Compte bloqué");
        }


        if (!account.currency().equals(transaction.getCurrency())) {
            throw new RuntimeException(
                    "Devise incompatible"
            );
        }


        if (account.balance().compareTo(transaction.getAmount()) < 0) {
            throw new RuntimeException(
                    "Solde insuffisant"
            );
        }

        accountFeignClient.debit(
                transaction.getAccountId(),
                transaction.getAmount()
        );


        transaction.setId(UUID.randomUUID());
        transaction.setCreatedAt(Instant.now());

        Transaction saved = transactionRepository.save(transaction);


        return saved;
    }

    public Transaction getTransaction(UUID id) {
        return transactionRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Transaction introuvable")
                );
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public List<Transaction> getByAccount(UUID accountId) {
        return transactionRepository.findByAccountId(accountId);
    }
}


