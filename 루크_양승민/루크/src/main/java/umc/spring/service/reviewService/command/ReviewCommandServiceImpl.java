package umc.spring.service.reviewService.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.ReviewConverter;
import umc.spring.converter.ReviewImageConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.ReviewImage;
import umc.spring.domain.Store;
import umc.spring.repository.ReviewRepository;
import umc.spring.service.S3UploadService;
import umc.spring.service.memberService.base.MemberBaseService;
import umc.spring.service.storeService.base.StoreBaseService;
import umc.spring.web.dto.reviewDTO.ReviewRequest;
import umc.spring.web.dto.reviewDTO.ReviewResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final MemberBaseService memberBaseService;
    private final StoreBaseService storeBaseService;
    private final S3UploadService uploadService;

    @Override
    @Transactional
    public ReviewResponse.AddResultDTO addReview(ReviewRequest.AddDto request) {
        Member member = memberBaseService.getMember(request);
        Store store = storeBaseService.getStore(request);

        store.calculateScore(request.getScore());

        List<ReviewImage> reviewImageList = getReviewImages(request);

        Review review = ReviewConverter.toReview(request, member, store);

        for (ReviewImage reviewImage : reviewImageList) {
            reviewImage.addReview(review);
        }

        return ReviewConverter.toAddResultDto(reviewRepository.save(review));
    }

    private List<ReviewImage> getReviewImages(ReviewRequest.AddDto request) {
        return request.getReviewImage().stream()
                .map(uploadService::saveFile)
                .map(ReviewImageConverter::toReviewImage)
                .collect(Collectors.toList());
    }
}
