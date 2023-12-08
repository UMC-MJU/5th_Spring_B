package umc.spring.service.missionService.base;

import umc.spring.domain.Mission;
import umc.spring.web.dto.missionDTO.MissionRequest;

public interface MissionBaseService {
    Mission getMission(MissionRequest.ChallengedDTO request);
}
