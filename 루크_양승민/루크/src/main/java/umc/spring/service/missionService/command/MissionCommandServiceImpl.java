package umc.spring.service.missionService.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.repository.MissionRepository;
import umc.spring.service.storeService.base.StoreBaseService;
import umc.spring.web.dto.missionDTO.MissionRequest;
import umc.spring.web.dto.missionDTO.MissionResponse;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService{

    private final MissionRepository missionRepository;
    private final StoreBaseService storeBaseService;

    @Override
    @Transactional
    public MissionResponse.AddResultDTO addMission(MissionRequest.AddDto request) {
        Store store = storeBaseService.getStore(request);

        Mission mission = MissionConverter.toMission(request, store);

        return MissionConverter.toAddResultDto(missionRepository.save(mission));
    }
}
