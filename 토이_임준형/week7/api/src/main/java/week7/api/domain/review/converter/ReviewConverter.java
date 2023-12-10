package week7.api.domain.review.converter;

import java.util.Collections;
import java.util.List;
import org.springframework.data.domain.Page;
import week7.api.domain.review.domain.Review;
import week7.api.domain.review.dto.ReviewListResponse;
import week7.api.domain.review.dto.ReviewResponse;
import week7.api.domain.store.domain.Store;

public class ReviewConverter {
    public static ReviewResponse toReviewResponse(Review review, Store store) {
        return ReviewResponse.builder()
//                .memberId(member.getId)
                .content(review.getContent())
                .storeName(store.getName())
                .build();
    }

    public static ReviewListResponse toReviewListResponse(List<ReviewResponse> reviewResponses, int totalPage,
                                                          long totalElements, boolean isFirst, boolean isLast) {
        return ReviewListResponse.builder()
                .reviewList(reviewResponses)
                .totalPage(totalPage)
                .totalElements(totalElements)
                .isFirst(isFirst)
                .isLast(isLast)
                .build();
    }
}
