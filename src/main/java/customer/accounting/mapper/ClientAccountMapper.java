package customer.accounting.mapper;

import customer.accounting.dto.ClientAccountDetailedResponse;
import customer.accounting.dto.ClientAccountRequest;
import customer.accounting.dto.ClientAccountResponse;
import customer.accounting.dto.ClientAccountUpdateRequest;
import customer.accounting.entity.ClientAccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClientAccountMapper {
    ClientAccountEntity toEntity(ClientAccountRequest request);
    ClientAccountResponse toClientAccountResponse(ClientAccountEntity entity);
    ClientAccountDetailedResponse toClientAccountDetailedResponse(ClientAccountEntity entity);
    void updateEntityFromRequest(ClientAccountUpdateRequest request,
                                 @MappingTarget ClientAccountEntity entity);
}
