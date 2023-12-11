package week7.api.domain.mission.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Page<MemberMission> findAllByMemberId(Pageable pageable) {

//        Member currentMember = SecurityContextHolder getContext().getAuthentication(). getMember();
//        Long memberId = currentMember.getId();
        Long memberId = 2L;
        return memberMissionRepository.findAllByMemberId(memberId, pageable);
    }

}
