package umc.study.converter;

import umc.study.domain.Review;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {

    public static ReviewResponseDTO.PostReviewDTO toPostReviewDTO(Review review) {
        return ReviewResponseDTO.PostReviewDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.PostDto request) {
        return Review.builder()
                .title(request.getTitle())
                .score(request.getScore())
                .build();
    }
}
