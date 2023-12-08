package umc.spring.service.memberService.base;

import umc.spring.domain.Member;
import umc.spring.web.dto.missionDTO.MissionRequest;
import umc.spring.web.dto.reviewDTO.ReviewRequest;

public interface MemberBaseService {
    Member getMember(ReviewRequest.AddDto request);

    Member getMember(MissionRequest.ChallengedDTO request);
}
