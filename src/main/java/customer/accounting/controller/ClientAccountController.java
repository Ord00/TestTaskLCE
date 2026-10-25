package customer.accounting.controller;

import customer.accounting.ClientAccountRequest;
import customer.accounting.ClientAccountResponse;
import customer.accounting.exception.ClientAccountException;
import customer.accounting.service.ClientAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientAccountController {
    private final ClientAccountService clientAccountService;

    @PutMapping("/{id}")
    public ResponseEntity<ClientAccountResponse> updateClientAccount(
            @PathVariable Long id,
            @RequestBody ClientAccountRequest request) {
        try {
            return ResponseEntity.ok(clientAccountService.updateClientAccount(id, request));
        } catch (ClientAccountException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClientAccount(@PathVariable Long id) {
        try {
            clientAccountService.deleteClientAccount(id);
            return ResponseEntity.noContent().build();
        } catch (ClientAccountException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ClientAccountResponse>> getAllClients() {
        return ResponseEntity.ok(clientAccountService.getAllClients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientAccountDetailedResponse> getClientAccount(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(clientAccountService.getClientAccount(id));
        } catch (ClientAccountException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
