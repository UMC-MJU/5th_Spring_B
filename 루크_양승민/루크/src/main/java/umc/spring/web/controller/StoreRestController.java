package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.service.storeService.command.StoreCommandService;
import umc.spring.service.storeService.query.StoreQueryService;
import umc.spring.validation.page.annotation.CheckPage;
import umc.spring.web.dto.storeDTO.StoreRequest;
import umc.spring.web.dto.storeDTO.StoreResponse;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
public class StoreRestController {

    private final StoreCommandService storeCommandService;
    private final StoreQueryService storeQueryService;

    @Operation(
            summary = "가게 추가 API",
            description = "지역 ID와 가게 정보를 받아 가게를 추가합니다."
    )
    @PostMapping("/")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공")
    })
    public ApiResponse<StoreResponse.AddResultDTO> addStore(
            @RequestBody @Valid StoreRequest.AddDto request
    ) {
        StoreResponse.AddResultDTO resultDTO = storeCommandService.addStore(request);
        return ApiResponse.onSuccess(resultDTO);
    }

    @Operation(
            summary = "특정 가게의 미션리스트 조회 API",
            description = "특정 가게의 ID를 받아 미션리스트를 조회합니다."
    )
    @GetMapping("/{storeId}/missions")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공")
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게 ID (Path Variable)"),
            @Parameter(name = "page", description = "페이지 번호 (Query String: 0번이 1페이지)")
    })
    public ApiResponse<StoreResponse.MissionListDTO> getMissionList(
            @PathVariable("storeId") Long storeId,
            @CheckPage @RequestParam("page") Integer page
    ) {
        StoreResponse.MissionListDTO resultDTO = storeQueryService.getMissionList(storeId, page);
        return ApiResponse.onSuccess(resultDTO);
    }

}
