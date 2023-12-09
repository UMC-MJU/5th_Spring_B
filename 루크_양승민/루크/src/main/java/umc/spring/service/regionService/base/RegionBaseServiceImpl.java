package umc.spring.service.regionService.base;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.RegionHandler;
import umc.spring.domain.Region;
import umc.spring.repository.RegionRepository;
import umc.spring.web.dto.storeDTO.StoreRequest;

@Service
@RequiredArgsConstructor
public class RegionBaseServiceImpl implements RegionBaseService {

    private final RegionRepository regionRepository;

    @Override
    public Region getRegion(StoreRequest.AddDto request) {
        return findRegionById(request.getRegionId());
    }

    @Override
    public boolean isExistedRegion(Long regionId) {
        return regionRepository.existsById(regionId);
    }

    private Region findRegionById(Long regionId) {
        return regionRepository.findById(regionId)
                .orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));
    }

}
