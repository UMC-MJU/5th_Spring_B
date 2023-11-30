package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Store;
import umc.spring.service.StoreService.StoreCommandService;
import umc.spring.web.dto.Store.StoreRequest;
import umc.spring.web.dto.Store.StoreResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/{storeId}/review/{memberId}")
    public ApiResponse<StoreResponse.AddReviewResultDTO> addReview(
            @PathVariable Long storeId,
            @PathVariable Long memberId,
            @RequestBody StoreRequest.AddReviewDto request
    ) {
        Store store = storeCommandService.addReview(storeId, memberId, request);
        return ApiResponse.onSuccess(StoreConverter.toAddReviewResultDTO(store));
    }

    @PostMapping("/{storeId}/mission")
    public ApiResponse<StoreResponse.AddMissionResultDTO> addMission(
            @PathVariable Long storeId,
            @RequestBody StoreRequest.AddMissionDto request
    ) {
        Store store = storeCommandService.addMission(storeId, request);
        return ApiResponse.onSuccess(StoreConverter.toAddMissionResultDTO(store));
    }
}
