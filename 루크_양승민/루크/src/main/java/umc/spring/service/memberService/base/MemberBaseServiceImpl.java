package umc.spring.service.memberService.base;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.MemberHandler;
import umc.spring.domain.Member;
import umc.spring.repository.MemberRepository;
import umc.spring.web.dto.missionDTO.MissionRequest;
import umc.spring.web.dto.reviewDTO.ReviewRequest;

@Service
@RequiredArgsConstructor
public class MemberBaseServiceImpl implements MemberBaseService {

    private final MemberRepository memberRepository;

    @Override
    public Member getMember(ReviewRequest.AddDto request) {
        return findMemberById(request.getMemberId());
    }

    @Override
    public Member getMember(MissionRequest.ChallengedDTO request) {
        return findMemberById(request.getMemberId());
    }

    @Override
    public Member getMember(Long memberId) {
        return findMemberById(memberId);
    }

    private Member findMemberById(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
    }
}
