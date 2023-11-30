package week7.api.domain.member.service;

import week7.api.domain.member.domain.Member;
import week7.api.domain.member.dto.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
}
