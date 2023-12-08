package umc.spring.service.missionService.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.web.dto.missionDTO.MissionRequest;

public interface MissionBaseService {
    Mission getMission(MissionRequest.ChallengedDTO request);

    Page<Mission> getAllMissionsByStore(Store store, PageRequest of);
}
