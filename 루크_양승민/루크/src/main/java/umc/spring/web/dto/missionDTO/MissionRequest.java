package umc.spring.web.dto.missionDTO;

import lombok.Getter;
import umc.spring.validation.annotation.SinceNowDate;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

public class MissionRequest {

    @Getter
    public static class AddDto {

        @NotEmpty
        Integer reward;

        @SinceNowDate
        LocalDate deadline;

        @NotEmpty
        String missionSpec;

        @NotEmpty
        Long storeId;

    }

    @Getter
    public static class ChallengedDTO {

        @NotEmpty
        Long memberId;

        @NotEmpty
        Long missionId;

    }
}
