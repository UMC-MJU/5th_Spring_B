package week7.api.domain.review.service;

import week7.api.domain.review.dto.ReviewCreateRequest;
import week7.api.domain.review.dto.ReviewResponse;

public interface ReviewService {
    ReviewResponse writeReview(ReviewCreateRequest request);
}
