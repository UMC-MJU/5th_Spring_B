package umc.spring.web.dto.Region;

import lombok.Getter;

public class RegionRequest {

    @Getter
    public static class AddStoreDto {
        Long regionId;

        String name;
        String address;
    }
}
