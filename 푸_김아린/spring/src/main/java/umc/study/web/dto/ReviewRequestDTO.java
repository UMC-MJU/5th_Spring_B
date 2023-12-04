package umc.study.web.dto;

import lombok.Getter;
import umc.study.domain.ReviewImage;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ReviewRequestDTO {
    @Getter
    public static class PostDto {
        @NotBlank
        String title;
        @NotNull
        Float score;

        List<ReviewImage> reviewImageList;
    }
}
