package customer.accounting.service;

import customer.accounting.dto.ClientAccountDetailedResponse;
import customer.accounting.dto.ClientAccountRequest;
import customer.accounting.dto.ClientAccountResponse;
import customer.accounting.dto.ClientAccountUpdateRequest;
import customer.accounting.entity.ClientAccountEntity;
import customer.accounting.exception.ClientAccountException;
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

    public ClientAccountResponse createClientAccount(ClientAccountRequest request) {
        log.info("Сохранение клиента c fullName = {} и gender = {}",
                request.getFullName(), request.getGender());
        ClientAccountEntity entity = clientAccountMapper.toEntity(request);
        entity.setStatus("ACTIVE");
        clientAccountRepository.save(entity);
        log.info("Клиент c fullName = {} и gender = {} сохранена с id = {}",
                request.getFullName(), request.getGender(), entity.getId());
        return clientAccountMapper.toClientAccountResponse(entity);
    }

    public List<ClientAccountResponse> getAllClients() {
        log.info("Получение данных о всех клиентах");
        List<ClientAccountResponse> responses = clientAccountRepository.findAll()
                .stream()
                .map(clientAccountMapper::toClientAccountResponse)
                .toList();
        log.info("Данные о всех клиентах получены");
        return responses;
    }

    public ClientAccountDetailedResponse getClientAccount(Long id) {
        log.info("Получение данных о клиенте с id = {}", id);
        ClientAccountEntity entity = clientAccountRepository.findById(id)
                .orElseThrow(() -> new ClientAccountException("Клиент не найден"));
        log.info("Получены данные о клиенте с id = {}", id);
        return clientAccountMapper.toClientAccountDetailedResponse(entity);
    }

    public ClientAccountResponse updateClientAccount(Long id, ClientAccountUpdateRequest request) {
        log.info("Обновление данных клиента с id = {}", id);
        ClientAccountEntity entity = clientAccountRepository.findById(id)
                .orElseThrow(() -> new ClientAccountException("Клиент не найден"));
        clientAccountMapper.updateEntityFromRequest(request, entity);
        clientAccountRepository.save(entity);
        log.info("Данные клиента с id = {} обновлены", id);
        return clientAccountMapper.toClientAccountResponse(entity);
    }

    public void deleteClientAccount(Long id) {
        log.info("Удаление данных клиента с id = {}", id);
        if (!clientAccountRepository.existsById(id)) {
            throw new ClientAccountException("Клиент не найден");
        }
        clientAccountRepository.deleteById(id);
        log.info("Данные клиента с id = {} удалены", id);
    }
}
