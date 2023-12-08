package umc.spring.service.memberService.query;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.converter.MemberConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.memberService.base.MemberBaseService;
import umc.spring.service.reviewService.base.ReviewBaseService;
import umc.spring.web.dto.memberDTO.MemberResponse;

@Service
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService {

    private final MemberBaseService memberBaseService;
    private final ReviewBaseService reviewBaseService;

    @Override
    public MemberResponse.ReviewPreviewListDTO getReviewList(Long memberId, Integer page) {
        Member member = memberBaseService.getMember(memberId);

        Page<Review> memberPage = reviewBaseService.getAllReviewsByMember(member, PageRequest.of(page, 10));

        return MemberConverter.toReviewPreviewListDTO(memberPage);
    }

    @Override
    public MemberResponse.MissionListDTO getMisisonList(Long memberId, Integer page) {
        Member member = memberBaseService.getMember(memberId);

        Page<MemberMission> memberMissionPage = memberBaseService.getAllMemberMissionByMember(member, PageRequest.of(page, 10));

        return MemberConverter.toMissionListDTO(memberMissionPage.map(MemberMission::getMission));
    }

}
