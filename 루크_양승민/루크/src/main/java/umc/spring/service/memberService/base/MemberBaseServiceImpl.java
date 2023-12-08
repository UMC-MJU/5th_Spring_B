package umc.spring.service.memberService.base;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.MemberHandler;
import umc.spring.domain.Member;
import umc.spring.domain.enums.MemberStatus;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.web.dto.missionDTO.MissionRequest;
import umc.spring.web.dto.reviewDTO.ReviewRequest;

@Service
@RequiredArgsConstructor
public class MemberBaseServiceImpl implements MemberBaseService {

    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

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

    @Override
    public Page<MemberMission> getAllMemberMissionByMemberAndStatus(Member member, MissionStatus status, PageRequest pageRequest) {
        return memberMissionRepository.findAllByMemberAndStatus(member, status, pageRequest);
    }

    private Member findMemberById(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
    }
}
