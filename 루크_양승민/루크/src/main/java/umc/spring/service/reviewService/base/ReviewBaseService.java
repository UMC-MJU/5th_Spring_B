package umc.spring.service.reviewService.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import umc.spring.domain.Member;
import umc.spring.domain.Review;

public interface ReviewBaseService {
    Page<Review> getAllReviewsByMember(Member member, PageRequest pageRequest);
}
