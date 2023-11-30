package umc.spring.web.dto.Store;

import lombok.Getter;

import java.util.List;

public class StoreRequest {

    @Getter
    public static class AddReviewDto {
        String title;
        Float score;

        List<String> imageUrl;
    }
}
