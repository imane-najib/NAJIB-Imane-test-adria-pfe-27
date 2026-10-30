package stage.ifm.accountservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import stage.ifm.accountservice.domain.Account;
import stage.ifm.accountservice.domain.StatusAccount;
import stage.ifm.accountservice.repository.AccountRepository;

import java.math.BigDecimal;
import java.util.UUID;

@SpringBootApplication
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner initDatabase(AccountRepository accountRepository) {

        return args -> {


            accountRepository.save(Account.builder()
                    .id(UUID.randomUUID())
                    .CustomerReference("CUST001")
                    .status( StatusAccount.ACTIVE)
                    .currency("MAD")
                    .balance(new BigDecimal("5000.00"))
                    .build());
            accountRepository.save(Account.builder()
                    .id(UUID.randomUUID())
                    .CustomerReference("CUST002")
                    .status( StatusAccount.ACTIVE)
                    .currency("MAD")
                    .balance(new BigDecimal("12000"))
                    .build());

            accountRepository.save(Account.builder()
                    .id(UUID.randomUUID())
                    .CustomerReference("CUST003")
                    .status( StatusAccount.BLOCKED)
                    .currency("MAD")
                    .balance(new BigDecimal("25000"))
                    .build());

        };
    }
}
