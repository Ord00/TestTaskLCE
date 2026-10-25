package customer.accounting.service;

import customer.accounting.ClientAccountResponse;
import customer.accounting.mapper.ClientAccountMapper;
import customer.accounting.repository.ClientAccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClientAccountService {
    private final ClientAccountRepository clientAccountRepository;
    private final ClientAccountMapper clientAccountMapper;

    public List<ClientAccountResponse> getAllClients() {
        log.info("Получение данных о всех клиентах");
        List<ClientAccountResponse> responses = clientAccountRepository.findAll()
                .stream()
                .map(clientAccountMapper::toClientAccountResponse)
                .toList();
        log.info("Данные о всех клиентах получены");
        return responses;
    }
}
