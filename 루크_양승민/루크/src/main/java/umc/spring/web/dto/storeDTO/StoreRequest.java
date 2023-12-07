package umc.spring.web.dto.storeDTO;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class StoreRequest {

    @Getter
    public static class AddDto {

        @NotEmpty
        String name;

        @NotEmpty
        String address;

        @Size(max = 5)
        Float score;

        @NotEmpty
        Long regionId;
    }
}
