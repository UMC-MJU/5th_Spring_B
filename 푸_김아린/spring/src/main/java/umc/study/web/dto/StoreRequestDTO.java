package umc.study.web.dto;

import lombok.Getter;
import umc.study.domain.ReviewImage;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class StoreRequestDTO {
    @Getter
    public static class ReviewDTO {
        @NotBlank
        String title;
        @NotBlank
        String body;
        @NotNull
        Float score;

        List<ReviewImage> reviewImageList;
    }
}
