package customer.accounting.mapper;

import customer.accounting.ClientAccountDetailedResponse;
import customer.accounting.ClientAccountRequest;
import customer.accounting.ClientAccountResponse;
import customer.accounting.entity.ClientAccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClientAccountMapper {
    ClientAccountEntity toEntity(ClientAccountRequest request);
    ClientAccountResponse toClientAccountResponse(ClientAccountEntity entity);
    ClientAccountDetailedResponse toClientAccountDetailedResponse(ClientAccountEntity entity);
}
