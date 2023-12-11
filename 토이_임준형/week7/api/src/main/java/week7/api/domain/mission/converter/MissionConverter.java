package week7.api.domain.mission.converter;

import java.util.List;
import org.springframework.data.domain.Page;
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

    public static List<MissionResponse> toMissionResponses(Page<Mission> missions) {

        return missions.map(mission -> MissionResponse.builder()
                .missionId(mission.getId())
                .storeId(mission.getStoreId())
                .content(mission.getContent())
                .build()
        ).toList();
    }
}
