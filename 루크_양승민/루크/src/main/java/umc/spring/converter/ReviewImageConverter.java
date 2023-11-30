package umc.spring.converter;

import umc.spring.domain.ReviewImage;

public class ReviewImageConverter {

    public static ReviewImage toReviewImage(String imgUrl){
        return ReviewImage.builder()
                .imageUrl(imgUrl)
                .build();
    }
}
