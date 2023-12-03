package umc.spring.service.regionService.base;

import umc.spring.domain.Region;
import umc.spring.web.dto.storeDTO.StoreRequest;

public interface RegionBaseService {
    Region getRegion(StoreRequest.AddDto request);
}
