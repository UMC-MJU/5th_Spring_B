package umc.spring.converter;

import umc.spring.domain.Store;
import umc.spring.web.dto.Region.RegionRequest;

public class StoreConverter {

    public static Store toStore(RegionRequest.AddStoreDto request){
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .build();
    }
}
