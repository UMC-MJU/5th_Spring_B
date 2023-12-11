package week7.api.domain.mission.controller;


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

    @GetMapping("/missions")
    public ApiResponse<MissionListResponse> getMissions(@RequestParam(required = false) String storeName, Pageable pageable) {
        return ApiResponse.onSuccess(missionService.getMissions(storeName, pageable));
    }
}
