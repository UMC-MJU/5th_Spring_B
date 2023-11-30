package umc.spring.converter;

import umc.spring.domain.Store;
import umc.spring.web.dto.Region.RegionResponse;

import java.time.LocalDateTime;

public class RegionConverter {

    public static RegionResponse.AddStoreResultDTO toAddStoreResultDTO(Store store){
        return RegionResponse.AddStoreResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
