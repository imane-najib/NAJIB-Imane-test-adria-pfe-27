package stage.ifm.transactionservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import stage.ifm.transactionservice.domain.Transaction;

import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {

    List<Transaction> findByAccountId(UUID accountId);
}