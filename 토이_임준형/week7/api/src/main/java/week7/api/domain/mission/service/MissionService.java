package week7.api.domain.mission.service;

import org.springframework.data.domain.Pageable;
import week7.api.domain.mission.dto.MissionCreateRequest;
import week7.api.domain.mission.dto.MissionListResponse;
import week7.api.domain.mission.dto.MissionResponse;

public interface MissionService {
    MissionResponse registerMission(MissionCreateRequest request);

    MissionListResponse getMissions(String storeName, Pageable pageable);
}
