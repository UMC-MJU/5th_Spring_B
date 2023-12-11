package week7.api.domain.mission.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import week7.api.domain.mission.dto.MissionCreateRequest;
import week7.api.domain.mission.dto.MissionListResponse;
import week7.api.domain.mission.dto.MissionResponse;
import week7.api.domain.mission.service.MissionService;
import week7.api.global.code.ApiResponse;

@RestController
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;

    @PostMapping("/mission")
    public ApiResponse<MissionResponse> writeReview(@RequestBody @Valid MissionCreateRequest request) {
        return ApiResponse.onSuccess(missionService.registerMission(request));
    }

    @Operation(summary = "모든 가게의 미션 목록 조회 API", description = "모든 가게의 미션들을 조회하는 API이며, 선택적으로 특정 스토어의 이름으로 필터링 가능합니다. 페이징을 포함합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "OK, 성공", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "미션을 찾을 수 없음", content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @Parameter(name = "storeName", description = "가게의 이름, query parameter 입니다.", required = false)

    @GetMapping("/missions")
    public ApiResponse<MissionListResponse> getMissions(@RequestParam(required = false) String storeName, Pageable pageable) {
        return ApiResponse.onSuccess(missionService.getMissions(storeName, pageable));
    }

    @Operation(summary = "내 미션 목록 조회 API", description = "현재 로그인한 사용자의 미션들을 조회하는 API이며, 페이징을 포함합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "OK, 성공", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "인증 필요", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "접근 권한 없음", content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @GetMapping("/myPage/missions")
    public ApiResponse<MissionListResponse> getMyMissions(Pageable pageable) {
        return ApiResponse.onSuccess(missionService.getMyMissions(pageable));
    }
}
