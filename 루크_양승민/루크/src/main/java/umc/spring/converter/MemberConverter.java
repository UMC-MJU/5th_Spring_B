package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.enums.Gender;
import umc.spring.web.dto.MemberRequest;
import umc.spring.web.dto.MemberResponse;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {
    public static MemberResponse.JoinResultDTO toJoinResultDto(Member member){
        return MemberResponse.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequest.JoinDto request){

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .age(request.getAge())
                .gender(gender)
                .username(request.getUsername())
                .memberPreferList(new ArrayList<>())
                .build();
    }
}
