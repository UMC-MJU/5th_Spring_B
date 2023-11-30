package umc.spring.service.StoreService;

import umc.spring.domain.Store;
import umc.spring.web.dto.Region.RegionRequest;
import umc.spring.web.dto.Store.StoreRequest;

public interface StoreCommandService {
    Store addReview(Long storeId, Long memberId, StoreRequest.AddReviewDto request);

    Store addMission(Long storeId, StoreRequest.AddMissionDto request);
}
