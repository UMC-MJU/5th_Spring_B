package week7.api.domain.review.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import week7.api.domain.review.dto.ReviewCreateRequest;
import week7.api.domain.review.dto.ReviewListResponse;
import week7.api.domain.review.dto.ReviewResponse;

public interface ReviewService {
    ReviewResponse registerReview(ReviewCreateRequest request);

    ReviewListResponse getReviewList(Long storeId, Pageable pageable);
}
