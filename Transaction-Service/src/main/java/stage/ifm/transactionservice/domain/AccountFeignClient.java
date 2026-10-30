package stage.ifm.transactionservice.domain;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(
        name = "ACCOUNT-SERVICE"
)
public interface AccountFeignClient {

    @GetMapping("/accounts/{id}")
    AccountDTO getAccount(@PathVariable UUID id);

    @PostMapping("/{id}/debit")
    AccountDTO debit(
            @PathVariable UUID id,
            @RequestParam BigDecimal amount
    );

    @PostMapping("/{id}/credit")
    AccountDTO credit(
            @PathVariable UUID id,
            @RequestParam BigDecimal amount
    );
}
