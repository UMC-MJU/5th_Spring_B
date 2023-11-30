package week7.api.domain.review.controller;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import week7.api.domain.review.dto.ReviewCreateRequest;
import week7.api.domain.review.dto.ReviewResponse;
import week7.api.domain.review.service.ReviewService;
import week7.api.global.code.ApiResponse;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    // 리뷰 작성
    @PostMapping("/review")
    public ApiResponse<ReviewResponse> writeReview(@RequestBody @Valid ReviewCreateRequest request) {
        return ApiResponse.onSuccess(reviewService.writeReview(request));
    }
}
