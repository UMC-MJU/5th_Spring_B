package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.service.reviewService.command.ReviewCommandService;
import umc.spring.web.dto.reviewDTO.ReviewRequest;
import umc.spring.web.dto.reviewDTO.ReviewResponse;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @Operation(
            summary = "리뷰 추가 API",
            description = "가게와 사용자 ID, 리뷰 정보를 받아 리뷰를 추가합니다."
    )
    @PostMapping("/")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공")
    })
    public ApiResponse<ReviewResponse.AddResultDTO> addReview(
            @RequestBody @Valid ReviewRequest.AddDto request
    ) {
        ReviewResponse.AddResultDTO resultDTO = reviewCommandService.addReview(request);
        return ApiResponse.onSuccess(resultDTO);
    }
}
