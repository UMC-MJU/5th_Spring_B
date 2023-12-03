package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.service.storeService.command.StoreCommandService;
import umc.spring.web.dto.storeDTO.StoreRequest;
import umc.spring.web.dto.storeDTO.StoreResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/")
    public ApiResponse<StoreResponse.AddResultDTO> add(
            @RequestBody @Validated StoreRequest.AddDto request
    ) {
        StoreResponse.AddResultDTO resultDTO = storeCommandService.addStore(request);
        return ApiResponse.onSuccess(resultDTO);
    }

}
