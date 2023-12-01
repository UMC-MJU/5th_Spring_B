package week7.api.domain.member.converter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import week7.api.domain.domain.Gender;
import week7.api.domain.member.domain.Member;
import week7.api.domain.member.dto.MemberRequestDTO;
import week7.api.domain.member.dto.MemberRequestDTO.JoinDto;
import week7.api.domain.member.dto.MemberResponseDTO;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member) {
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request) {

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NOT_SELECT;
                break;
        }

        LocalDateTime birthDayWithTime = createBirthday(request);

        return Member.builder()
                .name(request.getName())
                .address(request.getAddress())
                .birthday(birthDayWithTime)
                .gender(gender)
                .build();

    }

    private static LocalDateTime createBirthday(JoinDto request) {
        Integer birthYear = request.getBirthYear();
        Integer birthMonth = request.getBirthMonth();
        Integer birthDay = request.getBirthDay();
        LocalDate birthDayResult = LocalDate.of(birthYear, birthMonth, birthDay);
        LocalDateTime birthDayWithTime = birthDayResult.atStartOfDay();
        return birthDayWithTime;
    }
}
