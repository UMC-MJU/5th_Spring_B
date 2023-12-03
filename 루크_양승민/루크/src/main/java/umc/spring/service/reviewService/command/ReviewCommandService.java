package umc.spring.service.reviewService.command;

import umc.spring.web.dto.reviewDTO.ReviewRequest;
import umc.spring.web.dto.reviewDTO.ReviewResponse;

public interface ReviewCommandService {
    ReviewResponse.AddResultDTO addReview(ReviewRequest.AddDto request);
}
