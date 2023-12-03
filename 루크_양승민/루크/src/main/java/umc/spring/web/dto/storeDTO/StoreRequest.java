package umc.spring.web.dto.storeDTO;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;

public class StoreRequest {

    @Getter
    public static class AddDto {
        @NotEmpty
        String name;
        @NotEmpty
        String address;
        @NotEmpty
        Float score;
        @NotEmpty
        Long regionId;
    }
}
