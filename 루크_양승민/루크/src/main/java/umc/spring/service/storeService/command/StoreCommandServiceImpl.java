package umc.spring.service.storeService.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.repository.StoreRepository;
import umc.spring.service.regionService.base.RegionBaseService;
import umc.spring.web.dto.storeDTO.StoreRequest;
import umc.spring.web.dto.storeDTO.StoreResponse;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final RegionBaseService regionBaseService;

    @Override
    @Transactional
    public StoreResponse.AddResultDTO addStore(StoreRequest.AddDto request) {
        Region region = regionBaseService.getRegion(request);
        Store store = StoreConverter.toStore(request, region);
        return StoreConverter.toAddResultDto(storeRepository.save(store));
    }
}
