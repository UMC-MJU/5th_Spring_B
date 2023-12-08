package umc.spring.service.missionService.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.mapping.MemberMissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.service.memberService.base.MemberBaseService;
import umc.spring.service.missionService.base.MissionBaseService;
import umc.spring.service.storeService.base.StoreBaseService;
import umc.spring.web.dto.missionDTO.MissionRequest;
import umc.spring.web.dto.missionDTO.MissionResponse;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    private final MemberBaseService memberBaseService;
    private final StoreBaseService storeBaseService;
    private final MissionBaseService missionBaseService;

    @Override
    @Transactional
    public MissionResponse.AddResultDTO addMission(MissionRequest.AddDto request) {
        Store store = storeBaseService.getStore(request);

        Mission mission = MissionConverter.toMission(request, store);

        return MissionConverter.toAddResultDto(missionRepository.save(mission));
    }

    @Override
    @Transactional
    public MissionResponse.ChallengedResultDTO challengedMission(MissionRequest.ChallengedDTO request) {
        Member member = memberBaseService.getMember(request);

        Mission mission = missionBaseService.getMission(request);

        MemberMission memberMission = MemberMissionConverter.toMemberMission(member, mission);

        return MissionConverter.toChallengedResultDTO(memberMissionRepository.save(memberMission));
    }

    @Override
    @Transactional
    public MissionResponse.SuccessResultDTO succeedMission(MissionRequest.SucceedMissionDTO request) {
        MemberMission memberMission = memberBaseService.getMemberMission(request.getMemberMissionId());

        memberMission.changeStatus(MissionStatus.COMPLETE);

        return MissionConverter.toSuccessResultDTO(memberMission);
    }
}
