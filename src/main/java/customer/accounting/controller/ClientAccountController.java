package customer.accounting.controller;

import customer.accounting.ClientAccountRequest;
import customer.accounting.ClientAccountResponse;
import customer.accounting.service.ClientAccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clients")
@AllArgsConstructor
public class ClientAccountController {
    private final ClientAccountService clientAccountService;

    @PostMapping
    public ResponseEntity<ClientAccountResponse> createClientAccount(
            @RequestBody ClientAccountRequest request) {
        ClientAccountResponse response = clientAccountService.createClientAccount(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
