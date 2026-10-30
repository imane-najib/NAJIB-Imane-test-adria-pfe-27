package stage.ifm.accountservice.web.graphql;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import stage.ifm.accountservice.domain.Account;
import stage.ifm.accountservice.service.AccountService;

import java.util.List;
import java.util.UUID;

@Controller
public class AccountGraphQLController {
    private AccountService accountService;
    @QueryMapping
    public Account account(@Argument UUID id) {
        return accountService.getAccount(id);
    }

    @QueryMapping
    public List<Account> accounts() {
        return accountService.getAllAccounts();
    }


}
