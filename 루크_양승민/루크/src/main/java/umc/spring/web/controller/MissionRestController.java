package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.service.missionService.command.MissionCommandService;
import umc.spring.web.dto.missionDTO.MissionRequest;
import umc.spring.web.dto.missionDTO.MissionResponse;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mission")
public class MissionRestController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/")
    public ApiResponse<MissionResponse.AddResultDTO> addMission(
            @RequestBody @Valid MissionRequest.AddDto request
    ) {
        MissionResponse.AddResultDTO resultDTO = missionCommandService.addMission(request);
        return ApiResponse.onSuccess(resultDTO);
    }

    @PostMapping("/challenge")
    public ApiResponse<MissionResponse.ChallengedResultDTO> challengeMission(
            @RequestBody @Valid MissionRequest.ChallengedDTO request
    ) {
        MissionResponse.ChallengedResultDTO resultDTO = missionCommandService.challengedMission(request);
        return ApiResponse.onSuccess(resultDTO);
    }

}
