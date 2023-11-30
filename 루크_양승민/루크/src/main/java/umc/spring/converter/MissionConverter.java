package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.web.dto.Store.StoreRequest;

public class MissionConverter {

    public static Mission toMission(StoreRequest.AddMissionDto request){
        return Mission.builder()
                .reward(request.getReward())
                .deadline(request.getDeadline())
                .missionSpec(request.getMissionSpec())
                .build();
    }
}
