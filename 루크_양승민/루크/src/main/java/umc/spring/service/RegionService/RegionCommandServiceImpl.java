package umc.spring.service.RegionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.repository.RegionRepository;
import umc.spring.web.dto.Region.RegionRequest;

@Service
@RequiredArgsConstructor
public class RegionCommandServiceImpl implements RegionCommandService {

    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public Store addStore(RegionRequest.AddStoreDto request) {
        Region region = regionRepository.getReferenceById(request.getRegionId());

        Store store = StoreConverter.toStore(request);

        region.getStoreList().add(store);

        return store;
    }
}
