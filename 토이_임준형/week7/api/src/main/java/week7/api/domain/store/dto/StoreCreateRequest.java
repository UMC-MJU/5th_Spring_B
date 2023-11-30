package week7.api.domain.store.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class StoreCreateRequest {
    private String name;

    private String address;
}
