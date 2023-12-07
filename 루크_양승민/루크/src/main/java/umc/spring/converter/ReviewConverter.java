package umc.spring.converter;

import umc.spring.domain.*;
import umc.spring.web.dto.reviewDTO.ReviewRequest;
import umc.spring.web.dto.reviewDTO.ReviewResponse;

import java.time.LocalDateTime;

public class ReviewConverter {

    public static ReviewResponse.AddResultDTO toAddResultDto(Review review) {
        return ReviewResponse.AddResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequest.AddDto request, Member member, Store store) {
        return Review.builder()
                .content(request.getContent())
                .score(request.getScore())
                .member(member)
                .store(store)
                .build();
    }
}
