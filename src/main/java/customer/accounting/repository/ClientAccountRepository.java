package customer.accounting.repository;

import customer.accounting.entity.ClientAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientAccountRepository extends JpaRepository<ClientAccountEntity, UUID> {
}
