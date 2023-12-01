package week7.api.domain.mission.controller;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import week7.api.domain.mission.dto.MissionCreateRequest;
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
}
