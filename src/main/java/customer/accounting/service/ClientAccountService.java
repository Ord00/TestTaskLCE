package customer.accounting.service;

import customer.accounting.ClientAccountRequest;
import customer.accounting.ClientAccountResponse;
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

    public ClientAccountResponse updateClientAccount(Long id, ClientAccountRequest request) {
        log.info("Обновление данных клиента с id = {}", id);
        if (!clientAccountRepository.existsById(id)) {
            throw new ClientAccountException("Клиент не найден");
        }
        ClientAccountEntity entity = clientAccountMapper.toEntity(request);
        entity.setId(id);
        ClientAccountEntity updatedEntity = clientAccountRepository.save(entity);
        log.info("Данные клиента с id = {} обновлены", id);
        return clientAccountMapper.toClientAccountResponse(updatedEntity);
    }
}
