package week7.api.domain.base;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public abstract class BaseEntity {

    @Column(insertable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(insertable = false, updatable = false)
    @LastModifiedDate
    private LocalDateTime updatedAt;
}
