package week7.api.domain.domain;

import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import week7.api.domain.base.BaseEntity;

@Embeddable
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Address extends BaseEntity {

    private String city; // 용인시, 수원시 등
    private String zipcode; // 도로명 주소


}
