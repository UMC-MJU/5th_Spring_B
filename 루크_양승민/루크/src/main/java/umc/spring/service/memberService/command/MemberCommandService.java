package umc.spring.service.memberService.command;

import umc.spring.web.dto.memberDTO.MemberRequest;
import umc.spring.web.dto.memberDTO.MemberResponse;

public interface MemberCommandService {

    MemberResponse.JoinResultDTO joinMember(MemberRequest.JoinDto request);
}
