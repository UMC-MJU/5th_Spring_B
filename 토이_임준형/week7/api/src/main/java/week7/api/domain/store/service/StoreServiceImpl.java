package week7.api.domain.store.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import week7.api.domain.review.dto.ReviewCreateRequest;
import week7.api.domain.store.domain.Store;
import week7.api.domain.store.repository.StoreRepository;
import week7.api.global.code.status.ErrorStatus;
import week7.api.global.exception.handler.ReviewHandler;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    @Override
    public Store getStore(ReviewCreateRequest request) {
        Long storeId = request.getStoreId();
        return storeRepository.findById(storeId).orElseThrow(
                () -> new ReviewHandler(ErrorStatus.STORE_CATEGORY_NOT_FOUND));
    }

}
