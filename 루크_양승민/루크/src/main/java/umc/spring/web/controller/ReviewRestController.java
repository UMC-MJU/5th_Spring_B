package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.service.reviewService.command.ReviewCommandService;
import umc.spring.web.dto.reviewDTO.ReviewRequest;
import umc.spring.web.dto.reviewDTO.ReviewResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewRestController {

    private ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ApiResponse<ReviewResponse.AddResultDTO> addReview(
            @RequestBody @Validated ReviewRequest.AddDto request
    ) {
        ReviewResponse.AddResultDTO resultDTO = reviewCommandService.addReview(request);
        return ApiResponse.onSuccess(resultDTO);
    }
}
