package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.RegionConverter;
import umc.spring.domain.Store;
import umc.spring.service.RegionService.RegionCommandService;
import umc.spring.web.dto.Region.RegionRequest;
import umc.spring.web.dto.Region.RegionResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/region")
public class RegionRestController {

    private RegionCommandService regionCommandService;

    @PostMapping("/store")
    public ApiResponse<RegionResponse.AddStoreResultDTO> addStore(
            @RequestBody RegionRequest.AddStoreDto request
    ) {
        Store store = regionCommandService.addStore(request);
        return ApiResponse.onSuccess(RegionConverter.toAddStoreResultDTO(store));
    }
}
