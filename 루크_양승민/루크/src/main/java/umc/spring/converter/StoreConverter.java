package umc.spring.converter;

import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.web.dto.storeDTO.StoreRequest;
import umc.spring.web.dto.storeDTO.StoreResponse;

public class StoreConverter {

    public static StoreResponse.AddResultDTO toAddResultDto(Store store) {
        return StoreResponse.AddResultDTO.builder()
                .storeId(store.getId())
                .createdAt(store.getCreatedAt())
                .build();
    }

    public static Store toStore(StoreRequest.AddDto request, Region region){
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .score(request.getScore())
                .region(region)
                .build();
    }

}
