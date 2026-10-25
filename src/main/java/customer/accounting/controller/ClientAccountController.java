package customer.accounting.controller;

import customer.accounting.ClientAccountDetailedResponse;
import customer.accounting.exception.ClientAccountException;
import customer.accounting.service.ClientAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientAccountController {
    private final ClientAccountService clientAccountService;

    @GetMapping("/{id}")
    public ResponseEntity<ClientAccountDetailedResponse> getClientAccount(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(clientAccountService.getClientAccount(id));
        } catch (ClientAccountException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
