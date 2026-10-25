package customer.accounting.service;

import customer.accounting.ClientAccountRequest;
import customer.accounting.ClientAccountResponse;
import customer.accounting.entity.ClientAccountEntity;
import customer.accounting.mapper.ClientAccountMapper;
import customer.accounting.repository.ClientAccountRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class ClientAccountService {
    private final ClientAccountRepository clientAccountRepository;
    private final ClientAccountMapper clientAccountMapper;

    public ClientAccountResponse createClientAccount(ClientAccountRequest request) {
        log.info("Сохранение заявки c fullName = {} и gender = {}",
                request.getFullName(), request.getGender());
        ClientAccountEntity entity = clientAccountRepository.save(clientAccountMapper.toEntity(request));
        log.info("Заявка c fullName = {} и gender = {} сохранена с id = {}",
                request.getFullName(), request.getGender(), entity.getId());
        return clientAccountMapper.toClientAccountResponse(entity);
    }
}
