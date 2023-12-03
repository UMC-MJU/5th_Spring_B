package umc.spring.web.dto.missionDTO;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

public class MissionRequest {

    @Getter
    public static class AddDto {

        @NotEmpty
        Integer reward;
        @NotEmpty
        LocalDate deadline;
        @NotEmpty
        String missionSpec;
        @NotEmpty
        Long storeId;

    }
}
