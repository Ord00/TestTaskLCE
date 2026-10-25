package customer.accounting.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;

@Entity
@Table(name = "client_account")
@Data
public class ClientAccountEntity {
    @Id
    private Long id;

    @Column(name = "full_name", nullable = false, length = Integer.MAX_VALUE)
    private String fullName;

    @Column(name = "gender", length = 1)
    private String gender;

    @Column(name = "status", length = 20)
    private String status;

    @ColumnDefault("now()")
    @Column(name = "create_dttm", nullable = false)
    private OffsetDateTime createDttm;

    @UpdateTimestamp
    @Column(name = "modify_dttm", nullable = false)
    private OffsetDateTime modifyDttm;
}
