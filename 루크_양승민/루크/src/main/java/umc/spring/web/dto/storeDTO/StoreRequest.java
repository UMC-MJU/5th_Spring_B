package umc.spring.web.dto.storeDTO;

import lombok.Getter;
import umc.spring.validation.exist.annotation.ExistRegion;

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

        @ExistRegion
        Long regionId;
    }
}
