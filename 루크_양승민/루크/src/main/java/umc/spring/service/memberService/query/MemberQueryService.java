package umc.spring.service.memberService.query;

import umc.spring.web.dto.memberDTO.MemberResponse;

public interface MemberQueryService {
    MemberResponse.ReviewPreviewListDTO getReviewList(Long memberId, Integer page);

    MemberResponse.MissionListDTO getMisisonList(Long memberId, Integer page);
}
