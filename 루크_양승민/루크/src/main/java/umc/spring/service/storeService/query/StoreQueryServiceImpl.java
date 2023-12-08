package umc.spring.service.storeService.query;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.service.missionService.base.MissionBaseService;
import umc.spring.service.storeService.base.StoreBaseService;
import umc.spring.web.dto.storeDTO.StoreResponse;

@Service
@RequiredArgsConstructor
public class StoreQueryServiceImpl implements StoreQueryService{

    private final StoreBaseService storeBaseService;
    private final MissionBaseService missionBaseService;

    @Override
    public StoreResponse.MissionListDTO getMissionList(Long storeId, Integer page) {
        Store store = storeBaseService.getStore(storeId);

        Page<Mission> storePage = missionBaseService.getAllMissionsByStore(store, PageRequest.of(page, 10));

        return StoreConverter.toMissionListDTO(storePage);
    }
}
