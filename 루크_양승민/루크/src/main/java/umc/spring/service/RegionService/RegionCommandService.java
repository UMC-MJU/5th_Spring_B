package umc.spring.service.RegionService;

import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Store;
import umc.spring.web.dto.Region.RegionRequest;

public interface RegionCommandService {
    @Transactional
    Store addStore(RegionRequest.AddStoreDto request);
}
