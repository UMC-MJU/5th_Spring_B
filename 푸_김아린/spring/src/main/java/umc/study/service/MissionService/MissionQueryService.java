package umc.study.service.MissionService;

import org.springframework.data.domain.Page;
import umc.study.domain.Mission;

public interface MissionQueryService {
    Page<Mission> getMissionList(Integer page);
}
