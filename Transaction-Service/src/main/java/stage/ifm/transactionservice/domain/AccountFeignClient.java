package stage.ifm.transactionservice.domain;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.UUID;

@FeignClient(
        name = "ACCOUNT-SERVICE"
)
public interface AccountFeignClient {

    @GetMapping("/accounts/{id}")
    AccountDTO getAccount(@PathVariable UUID id);

    @PostMapping("accounts/{id}/debit")
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
