package umc.spring.service.memberService.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import umc.spring.domain.Member;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.missionDTO.MissionRequest;
import umc.spring.web.dto.reviewDTO.ReviewRequest;

public interface MemberBaseService {
    Member getMember(ReviewRequest.AddDto request);

    Member getMember(MissionRequest.ChallengedDTO request);

    Member getMember(Long memberId);

    Page<MemberMission> getAllMemberMissionByMember(Member member, PageRequest of);
}
