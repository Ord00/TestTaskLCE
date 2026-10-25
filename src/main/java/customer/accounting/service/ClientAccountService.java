package customer.accounting.service;

import customer.accounting.ClientAccountDetailedResponse;
import customer.accounting.entity.ClientAccountEntity;
import customer.accounting.exception.ClientAccountException;
import customer.accounting.mapper.ClientAccountMapper;
import customer.accounting.repository.ClientAccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClientAccountService {
    private final ClientAccountRepository clientAccountRepository;
    private final ClientAccountMapper clientAccountMapper;

    public ClientAccountDetailedResponse getClientAccount(Long id) {
        log.info("Получение данных о клиенте с id = {}", id);
        ClientAccountEntity entity = clientAccountRepository.findById(id);
        if (entity == null) {
            throw new ClientAccountException("Клиент не найден");
        }
        log.info("Получены данные о клиенте с id = {}", id);
        return clientAccountMapper.toClientAccountDetailedResponse(entity);
    }
}
