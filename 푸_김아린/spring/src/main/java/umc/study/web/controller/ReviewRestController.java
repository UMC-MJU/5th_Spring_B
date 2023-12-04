package umc.study.web.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Review;
import umc.study.service.ReviewService.ReviewCommandService;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.PostReviewDTO> post(@RequestBody @Valid ReviewRequestDTO.PostDto request) {
        Review review = reviewCommandService.postReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toPostReviewDTO(review));
    }
}
