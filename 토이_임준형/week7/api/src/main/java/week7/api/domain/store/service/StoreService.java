package week7.api.domain.store.service;

import week7.api.domain.review.dto.ReviewCreateRequest;
import week7.api.domain.store.domain.Store;
import week7.api.domain.store.dto.StoreCreateRequest;
import week7.api.domain.store.dto.StoreResponse;

public interface StoreService {
    Store getStore(ReviewCreateRequest request);

    StoreResponse registerStore(StoreCreateRequest request);
}
