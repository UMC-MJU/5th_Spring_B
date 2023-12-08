package umc.spring.service.storeService.query;

import umc.spring.web.dto.storeDTO.StoreResponse;

public interface StoreQueryService {
    StoreResponse.MissionListDTO getMissionList(Long storeId, Integer page);
}
