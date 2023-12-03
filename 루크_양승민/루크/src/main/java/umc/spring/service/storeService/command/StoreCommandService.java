package umc.spring.service.storeService.command;

import umc.spring.web.dto.storeDTO.StoreRequest;
import umc.spring.web.dto.storeDTO.StoreResponse;

public interface StoreCommandService {
    StoreResponse.AddResultDTO addStore(StoreRequest.AddDto request);
}
