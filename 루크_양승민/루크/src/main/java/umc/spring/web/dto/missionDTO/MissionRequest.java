package umc.spring.web.dto.missionDTO;

import lombok.Getter;
import umc.spring.validation.date.annotation.SinceNowDate;
import umc.spring.validation.exist.annotation.ExistMember;
import umc.spring.validation.exist.annotation.ExistMemberMission;
import umc.spring.validation.exist.annotation.ExistMission;
import umc.spring.validation.exist.annotation.ExistStore;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class MissionRequest {

    @Getter
    public static class AddDto {

        @Size
        Integer reward;

        @SinceNowDate
        LocalDate deadline;

        @NotEmpty
        String missionSpec;

        @ExistStore
        Long storeId;

    }

    @Getter
    public static class ChallengedDTO {

        @ExistMember
        Long memberId;

        @ExistMission
        Long missionId;

    }

    @Getter
    public static class SucceedMissionDTO {

        @ExistMemberMission
        Long memberMissionId;

    }
}
