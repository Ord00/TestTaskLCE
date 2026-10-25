package customer.accounting.controller;

import customer.accounting.ClientAccountResponse;
import customer.accounting.service.ClientAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientAccountController {
    private final ClientAccountService clientAccountService;

    @GetMapping
    public ResponseEntity<List<ClientAccountResponse>> getAllClients() {
        return ResponseEntity.ok(clientAccountService.getAllClients());
    }
}
