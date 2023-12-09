package umc.spring.service.missionService.base;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.MissionHandler;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.repository.MissionRepository;
import umc.spring.web.dto.missionDTO.MissionRequest;

@Service
@RequiredArgsConstructor
public class MissionBaseServiceImpl implements MissionBaseService {

    private final MissionRepository missionRepository;

    @Override
    public Mission getMission(MissionRequest.ChallengedDTO request) {
        return findMemberById(request.getMissionId());
    }

    @Override
    public Page<Mission> getAllMissionsByStore(Store store, PageRequest pageRequest) {
        return missionRepository.findAllByStore(store, pageRequest);
    }

    @Override
    public boolean isExistedMission(Long missionId) {
        return missionRepository.existsById(missionId);
    }

    private Mission findMemberById(Long missionId) {
        return missionRepository.findById(missionId)
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));
    }
}
