package umc.spring.converter;

import umc.spring.domain.ReviewImage;

public class ReviewImageConverter {

    public static ReviewImage toReviewImage(String imageUrl){
        return ReviewImage.builder()
                .imageUrl(imageUrl)
                .build();
    }

}
