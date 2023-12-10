package week7.api.domain.review.converter;

import java.util.List;
import week7.api.domain.review.domain.Review;
import week7.api.domain.review.dto.ReviewResponse;

public class ReviewConverter {
    public static ReviewResponse toReviewResponse(Review review, String storeName) {
        return ReviewResponse.builder()
//                .memberId(member.getId)
                .content(review.getContent())
                .storeName(storeName)
                .build();
    }

    public static ReviewResponse reviewPreViewDTO(Review review){
        return null;
    }


    public static ReviewResponse reviewPreViewListDTO(List<Review> reviewList){
        return null;
    }
}
