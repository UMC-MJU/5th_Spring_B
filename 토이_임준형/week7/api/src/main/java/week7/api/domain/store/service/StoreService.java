package week7.api.domain.store.service;

import week7.api.domain.review.dto.ReviewCreateRequest;
import week7.api.domain.store.domain.Store;

public interface StoreService {
    Store getStore(ReviewCreateRequest request);
}
