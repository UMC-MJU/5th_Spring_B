package umc.spring.service.missionService.command;

import umc.spring.web.dto.missionDTO.MissionRequest;
import umc.spring.web.dto.missionDTO.MissionResponse;

public interface MissionCommandService {
    MissionResponse.AddResultDTO addMission(MissionRequest.AddDto request);

    MissionResponse.ChallengedResultDTO challengedMission(MissionRequest.ChallengedDTO request);

    MissionResponse.SuccessResultDTO succeedMission(MissionRequest.SucceedMissionDTO request);
}
