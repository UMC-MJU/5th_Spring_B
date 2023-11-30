package week7.api.domain.store.converter;

import org.springframework.stereotype.Component;
import week7.api.domain.store.domain.Store;
import week7.api.domain.store.dto.StoreResponse;

@Component
public class StoreConverter {
    public static StoreResponse toResponse(Store store) {
        return StoreResponse.builder()
                .address(store.getAddress().toString())
                .name(store.getName())
                .build();
    }
}
