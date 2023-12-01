package week7.api.domain.review.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class ReviewResponse {
    private String content;
    private String storeName;
    private Long memberId;
    private String memberName;
}
