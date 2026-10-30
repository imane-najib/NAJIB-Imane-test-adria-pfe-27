package stage.ifm.accountservice.service;

import org.springframework.stereotype.Service;
import stage.ifm.accountservice.domain.Account;
import stage.ifm.accountservice.domain.StatusAccount;
import stage.ifm.accountservice.repository.AccountRepository;

import java.util.List;
import java.util.UUID;


@Service

public class AccountService {

    private  AccountRepository accountRepository;

    public Account createAccount(Account account) {

        if (account.getBalance() == null || account.getBalance() < 0) {
            throw new IllegalArgumentException(
                    "Solde invalide"
            );
        }

        if (account.getId() == null) {
            account.setId(UUID.randomUUID());
        }

        if (account.getStatus() == null || account.getStatus() == StatusAccount.BLOCKED) {
                account.setStatus(StatusAccount.ACTIVE);
        }

        return accountRepository.save(account);
    }


    public Account getAccount(UUID id) {

        return accountRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Account not found")
                );
    }

    public List<Account> getAllAccounts() {
        return  accountRepository.findAll();
    }

    public Account updateAccount(Account account) {
        Account oldAccount = getAccount(account.getId());
        if (oldAccount != null) {
            oldAccount.setBalance(account.getBalance());
            oldAccount.setStatus(account.getStatus());
            oldAccount.setCurrency(account.getCurrency());
            oldAccount.setCustomerReference(account.getCustomerReference());
        }
        return accountRepository.save(oldAccount);
    }





}

