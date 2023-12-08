package umc.spring.service.reviewService.base;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.repository.ReviewRepository;

@Service
@RequiredArgsConstructor
public class ReviewBaseServiceImpl implements ReviewBaseService{

    private final ReviewRepository reviewRepository;

    @Override
    public Page<Review> getAllReviewsByMember(Member member, PageRequest pageRequest) {
        return reviewRepository.findAllByMember(member, pageRequest);
    }
}
