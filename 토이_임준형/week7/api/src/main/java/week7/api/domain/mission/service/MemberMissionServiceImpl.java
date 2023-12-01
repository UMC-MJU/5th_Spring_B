package week7.api.domain.mission.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import week7.api.domain.member.domain.MemberMission;
import week7.api.domain.mission.repository.MemberMissionRepository;

@Service
@RequiredArgsConstructor
public class MemberMissionServiceImpl implements MemberMissionService{

    private final MemberMissionRepository memberMissionRepository;
    @Override
    public MemberMission save(MemberMission mission) {
        return memberMissionRepository.save(mission);
    }
}
