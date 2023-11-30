package week7.api.domain.converter;

import java.time.LocalDateTime;
import week7.api.domain.domain.Member;
import week7.api.domain.dto.MemberResponseDTO;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member) {
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
