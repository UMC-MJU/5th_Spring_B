package umc.spring.service.storeService.base;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.StoreHandler;
import umc.spring.domain.Store;
import umc.spring.repository.StoreRepository;
import umc.spring.web.dto.missionDTO.MissionRequest;
import umc.spring.web.dto.reviewDTO.ReviewRequest;

@Service
@RequiredArgsConstructor
public class StoreBaseServiceImpl implements StoreBaseService {

    private final StoreRepository storeRepository;

    @Override
    public Store getStore(ReviewRequest.AddDto request) {
        return findStoreById(request.getStoreId());
    }

    @Override
    public Store getStore(MissionRequest.AddDto request) {
        return findStoreById(request.getStoreId());
    }

    @Override
    public Store getStore(Long storeId) {
        return findStoreById(storeId);
    }

    @Override
    public boolean isExistedStore(Long storeId) {
        return storeRepository.existsById(storeId);
    }

    private Store findStoreById(Long storeId) {
        return storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
    }
}
