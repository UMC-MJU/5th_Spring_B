package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.enums.Gender;
import umc.spring.web.dto.memberDTO.MemberRequest;
import umc.spring.web.dto.memberDTO.MemberResponse;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberConverter {
    public static MemberResponse.JoinResultDTO toJoinResultDto(Member member) {
        return MemberResponse.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequest.JoinDto request) {

        Gender gender = null;

        switch (request.getGender()) {
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
                .birthday(request.getBirthday())
                .gender(gender)
                .username(request.getUsername())
                .memberPreferList(new ArrayList<>())
                .build();
    }

    public static MemberResponse.ReviewPreviewDTO toReviewPreviewDTO(Review review) {
        return MemberResponse.ReviewPreviewDTO.builder()
                .storeTitle(review.getStore().getName())
                .content(review.getContent())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .build();
    }

    public static MemberResponse.ReviewPreviewListDTO toReviewPreviewListDTO(Page<Review> reviewList) {
        List<MemberResponse.ReviewPreviewDTO> reviewPreviewListDTO = reviewList.stream()
                .map(MemberConverter::toReviewPreviewDTO)
                .collect(Collectors.toList());

        return MemberResponse.ReviewPreviewListDTO.builder()
                .reviewList(reviewPreviewListDTO)
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreviewListDTO.size())
                .build();
    }

    public static MemberResponse.MissionDTO toMissionDTO(Mission mission) {
        return MemberResponse.MissionDTO.builder()
                .missionSpec(mission.getMissionSpec())
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .build();
    }

    public static MemberResponse.MissionListDTO toMissionListDTO(Page<Mission> missionList) {
        List<MemberResponse.MissionDTO> missionListDTO = missionList.stream()
                .map(MemberConverter::toMissionDTO)
                .collect(Collectors.toList());

        return MemberResponse.MissionListDTO.builder()
                .missionList(missionListDTO)
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionListDTO.size())
                .build();
    }
}
