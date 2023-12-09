package umc.spring.service.storeService.base;

import umc.spring.domain.Store;
import umc.spring.web.dto.missionDTO.MissionRequest;
import umc.spring.web.dto.reviewDTO.ReviewRequest;

public interface StoreBaseService {
    Store getStore(ReviewRequest.AddDto request);

    Store getStore(MissionRequest.AddDto request);

    Store getStore(Long storeId);

    boolean isExistedStore(Long storeId);
}
