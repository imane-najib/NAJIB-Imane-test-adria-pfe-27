package stage.ifm.transactionservice.domain;

import java.math.BigDecimal;
import java.util.UUID;

public record AccountDTO(
        UUID id,
        String customerReference,
        String status,
        String currency,
        BigDecimal balance
) {}