package week7.api.domain.mission.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import week7.api.domain.domain.Mission;
import week7.api.domain.domain.Status;
import week7.api.domain.member.domain.MemberMission;
import week7.api.domain.mission.converter.MissionConverter;
import week7.api.domain.mission.dto.MissionCreateRequest;
import week7.api.domain.mission.dto.MissionResponse;
import week7.api.domain.mission.repository.MissionRepository;
import week7.api.domain.store.domain.Store;
import week7.api.domain.store.service.StoreService;

@Service
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService {

    private final StoreService storeService;
    private final MemberMissionService memberMissionService;
    private final MissionRepository missionRepository;

    @Override
    public MissionResponse writeReview(MissionCreateRequest request) {

        String content = request.getContent();
        Long storeId = request.getStoreId();

        storeService.findStoreById(storeId);

        Mission mission = Mission.builder()
                .content(content)
                .build();
        Mission newMission = missionRepository.save(mission);

        // String name = SecurityContextHolder.getContext().getAuthentication().getName
        // Member findMember = memberRepository.findByName(name).orEls~

        // Member 연관관계 자동 세팅
        MemberMission memberMission = MemberMission.builder()
                .mission(newMission)
//                .member(findMember)
                .missionStatus(Status.IN_PROGRESS)
                .build();

        memberMissionService.save(memberMission);

        return MissionConverter.toMissionResponse(newMission, storeId);
    }
}
