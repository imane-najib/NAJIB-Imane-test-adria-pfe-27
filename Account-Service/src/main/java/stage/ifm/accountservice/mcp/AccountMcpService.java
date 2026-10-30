package stage.ifm.accountservice.mcp;

import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.stereotype.Service;
import stage.ifm.accountservice.domain.Account;
import stage.ifm.accountservice.service.AccountService;

import java.util.List;
import java.util.UUID;

@Service
public class AccountMcpService {
    private AccountService accountService;

    @McpTool(
            name = "get_account",
            description = "Consulter un compte bancaire par son identifiant"
    )
    public Account getAccount(String id) {
        return accountService.getAccount(UUID.fromString(id));
    }

    @McpTool(
            name = "get_accounts",
            description = "Consulter tous les comptes bancaires"
    )
    public List<Account> getAllAccount() {
        return accountService.getAllAccounts();
    }
}
