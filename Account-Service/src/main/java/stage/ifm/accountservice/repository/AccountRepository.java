package stage.ifm.accountservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stage.ifm.accountservice.domain.Account;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {
}
