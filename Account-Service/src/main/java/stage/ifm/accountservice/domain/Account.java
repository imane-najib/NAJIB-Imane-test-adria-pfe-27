package stage.ifm.accountservice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data @NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
    @Id
    private UUID id;

    private String CustomerReference;

    @Enumerated(EnumType.STRING)
    private StatusAccount status;

    private String currency;

    private BigDecimal balance;

}
