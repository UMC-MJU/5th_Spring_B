package week7.api.domain.mission.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import week7.api.domain.domain.Mission;
import week7.api.domain.domain.Status;
import week7.api.domain.member.domain.MemberMission;
import week7.api.domain.mission.converter.MissionConverter;
import week7.api.domain.mission.dto.MissionCreateRequest;
import week7.api.domain.mission.dto.MissionListResponse;
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
    public MissionResponse registerMission(MissionCreateRequest request) {

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

    @Override
    public MissionListResponse getMissions(String storeName, Pageable pageable) {
        // 검색 조건은 MissionCondition 객체로 StoreName, StoreId, Address 등으로 검색할 수 있게해야함
        // 값이 null이던 아니던 querydsl로 조건문에서 조합하여 해결 가능

        Store store = storeService.findStoreByName(storeName);
        Long storeId = store.getId();
        Page<Mission> missions = missionRepository.findAllByStoreId(storeId, pageable);

        List<MissionResponse> missionResponses = MissionConverter.toMissionResponses(missions);

        return MissionListResponse.builder()
                .missionResponses(missionResponses)
                .totalPage(missions.getTotalPages())
                .totalElements(missions.getTotalElements())
                .isFirst(missions.isFirst())
                .isLast(missions.isLast())
                .build();
    }
}
