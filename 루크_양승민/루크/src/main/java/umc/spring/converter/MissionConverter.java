package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.missionDTO.MissionRequest;
import umc.spring.web.dto.missionDTO.MissionResponse;

import java.time.LocalDateTime;

public class MissionConverter {

    public static MissionResponse.AddResultDTO toAddResultDto(Mission mission){
        return MissionResponse.AddResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static MissionResponse.ChallengedResultDTO toChallengedResultDTO(MemberMission memberMission) {
        return MissionResponse.ChallengedResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(MissionRequest.AddDto request, Store store){
        return Mission.builder()
                .reward(request.getReward())
                .deadline(request.getDeadline())
                .missionSpec(request.getMissionSpec())
                .store(store)
                .build();
    }
}
