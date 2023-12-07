package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class ReviewResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PostReviewDTO {
        Long reviewId;
        LocalDateTime createdAt;
        String nickname;
        Float score;
        String reviewContent;
        List<String> reviewImageList;
    }
}
