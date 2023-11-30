package umc.spring.service.MemberService;

import umc.spring.domain.Member;
import umc.spring.web.dto.Member.MemberRequest;

public interface MemberCommandService {

    Member joinMember(MemberRequest.JoinDto request);
}
