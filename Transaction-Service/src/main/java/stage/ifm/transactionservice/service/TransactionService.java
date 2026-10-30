package stage.ifm.transactionservice.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stage.ifm.transactionservice.domain.Transaction;
import stage.ifm.transactionservice.repository.TransactionRepository;

import java.math.BigDecimal;

@Service
@Transactional
public class TransactionService {

    private TransactionRepository repository;




    public Transaction createTransaction (Transaction transaction) {

        if (transaction.getAmount() == null || transaction.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(
                    "Le montant doit être positif"
            );
        }









        return saved;
    }
}

