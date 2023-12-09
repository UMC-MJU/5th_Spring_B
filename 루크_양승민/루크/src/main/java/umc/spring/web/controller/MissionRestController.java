package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(
            summary = "미션 추가 API",
            description = "미션의 정보를 받아 특정 가게에 미션을 추가합니다."
    )
    @PostMapping("/")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공")
    })
    public ApiResponse<MissionResponse.AddResultDTO> addMission(
            @RequestBody @Valid MissionRequest.AddDto request
    ) {
        MissionResponse.AddResultDTO resultDTO = missionCommandService.addMission(request);
        return ApiResponse.onSuccess(resultDTO);
    }

    @Operation(
            summary = "미션 도전 API",
            description = "미션과 사용자의 ID를 받아 미션 진행 목록에 추가합니다."
    )
    @PostMapping("/challenge")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공")
    })
    public ApiResponse<MissionResponse.ChallengedResultDTO> challengeMission(
            @RequestBody @Valid MissionRequest.ChallengedDTO request
    ) {
        MissionResponse.ChallengedResultDTO resultDTO = missionCommandService.challengedMission(request);
        return ApiResponse.onSuccess(resultDTO);
    }

    @Operation(
            summary = "미션 성공 API",
            description = "사용자 미션 ID를 받아 미션 상태를 진행 완료로 업데이트합니다."
    )
    @PostMapping("/success")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공")
    })
    public ApiResponse<MissionResponse.SuccessResultDTO> succeedMission(
            @RequestBody @Valid MissionRequest.SucceedMissionDTO request
    ) {
        MissionResponse.SuccessResultDTO resultDTO = missionCommandService.succeedMission(request);
        return ApiResponse.onSuccess(resultDTO);
    }

}
