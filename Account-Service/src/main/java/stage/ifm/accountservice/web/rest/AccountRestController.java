package stage.ifm.accountservice.web.rest;


import org.springframework.web.bind.annotation.*;
import stage.ifm.accountservice.domain.Account;
import stage.ifm.accountservice.service.AccountService;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
public class AccountRestController {
    private AccountService accountService;

    @PostMapping("/account")
    public Account CreateAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @GetMapping("/account/{id}")
    public Account getAccountById(@PathVariable UUID id) {
        return accountService.getAccount(id);
    }

    @GetMapping("/account")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @PutMapping("account")
    public Account updateAccount(@RequestBody Account account) {
        return accountService.updateAccount(account);
    }
    @PostMapping("accounts/{id}/credit")
    public Account credit(
            @PathVariable UUID id,
            @RequestParam BigDecimal amount) {
        return accountService.credit(id, amount);
    }

    @PostMapping("accounts/{id}/debit")
    public Account debit(
            @PathVariable UUID id,
            @RequestParam BigDecimal amount) {
        return accountService.debit(id, amount);
    }
}
