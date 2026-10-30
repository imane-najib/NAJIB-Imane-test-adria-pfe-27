package stage.ifm.accountservice.web.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stage.ifm.accountservice.domain.Account;
import stage.ifm.accountservice.service.AccountService;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
public class AccountRestController {

    private final AccountService accountService;

    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/rest/account")
    public Account CreateAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @GetMapping("/rest/account/{id}")
    public Account getAccountById(@PathVariable UUID id) {
        return accountService.getAccount(id);
    }

    @GetMapping("/rest/accounts")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @PutMapping("/rest/account")
    public Account updateAccount(@RequestBody Account account) {
        return accountService.updateAccount(account);
    }
    @PostMapping("/rest/accounts/{id}/credit")
    public Account credit(
            @PathVariable UUID id,
            @RequestParam BigDecimal amount) {
        return accountService.credit(id, amount);
    }

    @PostMapping("/rest/accounts/{id}/debit")
    public Account debit(
            @PathVariable UUID id,
            @RequestParam BigDecimal amount) {
        return accountService.debit(id, amount);
    }
}
