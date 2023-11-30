package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.web.dto.Store.StoreRequest;

import java.util.stream.Collectors;

public class ReviewConverter {

    public static Review toReview(Member member, StoreRequest.AddReviewDto request){
        return Review.builder()
                .title(request.getTitle())
                .score(request.getScore())
                .member(member)
                .reviewImageList(request.getImageUrl().stream()
                        .map(ReviewImageConverter::toReviewImage)
                        .collect(Collectors.toList()))
                .build();
    }
}
