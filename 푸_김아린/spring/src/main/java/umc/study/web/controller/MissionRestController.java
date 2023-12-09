package umc.study.web.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MissionConverter;
import umc.study.converter.StoreConverter;
import umc.study.domain.Mission;
import umc.study.service.MissionService.MissionCommandService;
import umc.study.service.MissionService.MissionQueryService;
import umc.study.service.StoreQueryService.StoreQueryService;
import umc.study.validation.annotation.ExistStore;
import umc.study.validation.annotation.ValidPage;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;
import umc.study.web.dto.StoreResponseDTO;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mission")
public class MissionRestController {
    private final MissionCommandService missionCommandService;
    private final MissionQueryService missionQueryService;
    private final StoreQueryService storeQueryService;

    @PostMapping("/")
    public ApiResponse<MissionResponseDTO.AddMissionDTO> add(@RequestBody @Valid MissionRequestDTO.AddDto request) {
        Mission mission = missionCommandService.addMission(request);

        return ApiResponse.onSuccess(MissionConverter.toAddResultDTO(mission));
    }

    @Operation(summary = "내가 진행중인 미션 목록 조회 API", description = "내가 진행중인 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다.")
    @GetMapping("/mission")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),
    })
    public ApiResponse<MissionResponseDTO.MissionPreViewListDTO> getMyMissionList(@RequestParam(name = "page") @ValidPage Integer page) {
        Page<Mission> missionPage = missionQueryService.getMissionList(page);

        List<MissionResponseDTO.MissionPreViewDTO> missionPreViewDTOList = missionPage.getContent().stream()
                .map(MissionConverter::missionPreViewDTO)
                .collect(Collectors.toList());

        MissionResponseDTO.MissionPreViewListDTO missionPreViewDTO = MissionConverter.missionPreViewListDTO(missionPage);

        return ApiResponse.onSuccess(missionPreViewDTO);
    }



    @GetMapping("/{storeId}/missions")
    @Operation(summary = "특정 가게의 미션 목록 조회 API", description = "특정 가게의 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "missionId", description = "가게의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),
    })
    public ApiResponse<StoreResponseDTO.MissionPreViewListDTO> getMissionList(@ExistStore @PathVariable(name = "storeId") Long storeId, @RequestParam(name = "page") @ValidPage Integer page) {
        Page<Mission> missionPage = storeQueryService.getMissionList(storeId, page);

        List<StoreResponseDTO.MissionPreViewDTO> missionPreViewDTOList = missionPage.getContent().stream()
                .map(StoreConverter::missionPreViewDTO)
                .collect(Collectors.toList());

        StoreResponseDTO.MissionPreViewListDTO missionPreViewListDTO = StoreConverter.missionPreViewListDTO(missionPage);

        return ApiResponse.onSuccess(missionPreViewListDTO);
    }
}
