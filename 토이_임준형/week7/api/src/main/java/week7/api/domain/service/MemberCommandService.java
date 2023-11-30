package week7.api.domain.service;

import week7.api.domain.domain.Member;
import week7.api.domain.dto.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
}
