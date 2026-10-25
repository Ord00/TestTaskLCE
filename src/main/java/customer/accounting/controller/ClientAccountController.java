package customer.accounting.controller;

import customer.accounting.exception.ClientAccountException;
import customer.accounting.service.ClientAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientAccountController {
    private final ClientAccountService clientAccountService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClientAccount(@PathVariable Long id) {
        try {
            clientAccountService.deleteClientAccount(id);
            return ResponseEntity.noContent().build();
        } catch (ClientAccountException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
