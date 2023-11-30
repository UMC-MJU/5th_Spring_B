package week7.api.domain.store.controller;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import week7.api.domain.review.dto.ReviewCreateRequest;
import week7.api.domain.store.dto.StoreCreateRequest;
import week7.api.domain.store.dto.StoreResponse;
import week7.api.domain.store.service.StoreService;
import week7.api.global.code.ApiResponse;

@RestController
@RequiredArgsConstructor
public class StoreRestController {

    private final StoreService storeService;
    @PostMapping("/store")
    public ApiResponse<StoreResponse> writeReview(@RequestBody @Valid StoreCreateRequest request) {
        return ApiResponse.onSuccess(storeService.registerStore(request));
    }
}
