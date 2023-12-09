package umc.spring.web.dto.memberDTO;

import lombok.Getter;
import umc.spring.validation.exist.annotation.ExistCategories;
import umc.spring.validation.date.annotation.UntilNowDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

public class MemberRequest {

    @Getter
    public static class JoinDto {
        @NotBlank
        String username;

        @Size(min = 1, max = 3)
        Integer gender;

        @NotNull
        Integer age;

        @UntilNowDate
        LocalDate birthday;

        @Size(min = 5, max = 12)
        String address;

        @Size(min = 5, max = 12)
        String specAddress;

        @ExistCategories
        List<Long> preferCategory;
    }
}
