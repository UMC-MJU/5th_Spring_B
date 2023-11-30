package umc.spring.web.dto.Store;

import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

public class StoreRequest {

    @Getter
    public static class AddReviewDto {

        String title;
        Float score;

        List<String> imageUrl;
    }

    @Getter
    public static class AddMissionDto {

        Integer reward;
        LocalDate deadline;
        String missionSpec;

    }
}
