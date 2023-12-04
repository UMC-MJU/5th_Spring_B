package umc.study.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.MissionConverter;
import umc.study.domain.Mission;
import umc.study.repository.MissionRepository;
import umc.study.web.dto.MissionRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionCommandServiceImpl implements MissionCommandService {
    private final MissionRepository missionRepository;

    @Override
    @Transactional
    public Mission addMission(MissionRequestDTO.AddDto request) {
        Mission newMission = MissionConverter.toMission(request);

        return missionRepository.save(newMission);
    }
}
