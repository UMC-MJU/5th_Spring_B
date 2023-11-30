package umc.study.web.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class MissionRequestDTO {
    @Getter
    public static class AddDto {
        @NotNull
        Integer reward;
        @NotBlank
        LocalDate deadline;
        @NotBlank
        String missionSpec;
    }
}
