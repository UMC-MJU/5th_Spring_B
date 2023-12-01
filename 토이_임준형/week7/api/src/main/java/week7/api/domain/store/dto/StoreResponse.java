package week7.api.domain.store.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class StoreResponse {

    private String name;
    private String address;
}
