package umc.study.service.ReviewService;

import org.springframework.data.domain.Page;
import umc.study.domain.Review;

import java.util.Optional;

public interface ReviewQueryService {
    Page<Review> getReviewList(Integer page);
}
