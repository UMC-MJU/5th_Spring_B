package umc.spring.converter;

import umc.spring.domain.Store;
import umc.spring.web.dto.Region.RegionRequest;
import umc.spring.web.dto.Store.StoreResponse;

import java.time.LocalDateTime;

public class StoreConverter {

    public static StoreResponse.AddReviewResultDTO toAddReviewResultDTO(Store store){
        return StoreResponse.AddReviewResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(RegionRequest.AddStoreDto request){
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .build();
    }
}
