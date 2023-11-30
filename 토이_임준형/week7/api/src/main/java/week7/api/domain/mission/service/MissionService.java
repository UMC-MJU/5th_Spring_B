package week7.api.domain.mission.service;

import week7.api.domain.mission.dto.MissionCreateRequest;
import week7.api.domain.mission.dto.MissionResponse;

public interface MissionService {
    MissionResponse writeReview(MissionCreateRequest request);
}
