package week7.api.domain.review.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import week7.api.domain.review.converter.ReviewConverter;
import week7.api.domain.review.domain.Review;
import week7.api.domain.review.dto.ReviewCreateRequest;
import week7.api.domain.review.dto.ReviewResponse;
import week7.api.domain.review.repository.ReviewRepository;
import week7.api.domain.store.domain.Store;
import week7.api.domain.store.service.StoreService;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{

    private final StoreService storeService;
    private final ReviewRepository reviewRepository;

    @Override
    public ReviewResponse registerReview(ReviewCreateRequest request) {

        Store store = storeService.getStore(request);

        // String name = SecurityContextHolder.getContext().getAuthentication().getName
        // Member findMember = memberRepository.findByName(name).orEls~

        Review newReview = Review.builder()
                .content(request.getContent())
//                .member(findMember)
                .store(store)
                .build();

        reviewRepository.save(newReview);

        return ReviewConverter.toReviewResponse(newReview, request.getContent());
    }

}
