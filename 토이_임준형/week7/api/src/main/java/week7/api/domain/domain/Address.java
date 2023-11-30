package week7.api.domain.domain;

import javax.persistence.Embeddable;
import week7.api.domain.base.BaseEntity;

@Embeddable
public class Address extends BaseEntity {

    private String province;    // 경기도, 강원도 등
    private String city; // 용인시, 수원시 등
    private String district; // 수지구 등
    private String neighbored; // 상현동 등
    private String zipcode; // 도로명 주소


}
