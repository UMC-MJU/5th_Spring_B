package week7.api.domain.mission.converter;

import week7.api.domain.domain.Mission;
import week7.api.domain.mission.dto.MissionResponse;

public class MissionConverter {
    public static MissionResponse toMissionResponse(Mission mission, Long storeId) {
        return MissionResponse.builder()
                .storeId(storeId)
                .memberId(mission.getId())
                .missionId(mission.getId())
                .content(mission.getContent())
                .build();
    }
}
