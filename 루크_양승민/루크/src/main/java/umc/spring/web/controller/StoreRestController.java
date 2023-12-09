package umc.spring.web.controller;

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

    @PostMapping("/")
    public ApiResponse<StoreResponse.AddResultDTO> add(
            @RequestBody @Valid StoreRequest.AddDto request
    ) {
        StoreResponse.AddResultDTO resultDTO = storeCommandService.addStore(request);
        return ApiResponse.onSuccess(resultDTO);
    }

    @GetMapping("/{storeId}/missions")
    public ApiResponse<StoreResponse.MissionListDTO> getMissionList(
            @PathVariable("storeId") Long storeId,
            @CheckPage @RequestParam("page") Integer page
    ) {
        StoreResponse.MissionListDTO resultDTO = storeQueryService.getMissionList(storeId, page);
        return ApiResponse.onSuccess(resultDTO);
    }

}
