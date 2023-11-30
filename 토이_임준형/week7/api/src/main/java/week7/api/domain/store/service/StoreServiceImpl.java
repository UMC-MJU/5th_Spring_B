package week7.api.domain.store.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import week7.api.domain.domain.Address;
import week7.api.domain.review.dto.ReviewCreateRequest;
import week7.api.domain.store.domain.Store;
import week7.api.domain.store.dto.StoreCreateRequest;
import week7.api.domain.store.dto.StoreResponse;
import week7.api.domain.store.repository.StoreRepository;
import week7.api.global.code.status.ErrorStatus;
import week7.api.global.exception.handler.ReviewHandler;
import week7.api.global.exception.handler.StoreHandler;

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

    @Override
    public StoreResponse registerStore(StoreCreateRequest request) {

        String fullAddress = request.getAddress();

        int cityIndex = validAddress(fullAddress);

        String city = fullAddress.substring(0, cityIndex + 1); // "서울특별시"
        String zipcode = fullAddress.substring(cityIndex + 2); // "양천구 목동로 1313"

        Address storeAddress = Address.builder()
                .city(city)
                .zipcode(zipcode)
                .build();

        Store newStore = Store.builder()
                .address(storeAddress)
                .name(request.getName())
                .build();

        Store save = storeRepository.save(newStore);

        // converter 과정 생략
        return StoreResponse.builder()
                .address(save.getAddress().toString())
                .name(save.getName())
                .build();
    }

    private int validAddress(String fullAddress) {
        // "시"를 기준으로 주소를 분할
        int cityIndex = fullAddress.indexOf("시 ");
        if (cityIndex == -1) {
            // "시 "가 주소에 없는 경우 에러 처리
            throw new StoreHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND);
        }
        return cityIndex;
    }

}
