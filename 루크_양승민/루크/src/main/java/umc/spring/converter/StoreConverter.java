package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.web.dto.missionDTO.MissionResponse;
import umc.spring.web.dto.storeDTO.StoreRequest;
import umc.spring.web.dto.storeDTO.StoreResponse;

import java.util.List;
import java.util.stream.Collectors;

public class StoreConverter {

    public static StoreResponse.AddResultDTO toAddResultDto(Store store) {
        return StoreResponse.AddResultDTO.builder()
                .storeId(store.getId())
                .createdAt(store.getCreatedAt())
                .build();
    }

    public static Store toStore(StoreRequest.AddDto request, Region region) {
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .score(request.getScore())
                .region(region)
                .build();
    }

    public static StoreResponse.MissionDTO toMissionDTO(Mission mission) {
        return StoreResponse.MissionDTO.builder()
                .missionSpec(mission.getMissionSpec())
                .deadline(mission.getDeadline())
                .reward(mission.getReward())
                .build();
    }

    public static StoreResponse.MissionListDTO toMissionListDTO(Page<Mission> missionList) {
        List<StoreResponse.MissionDTO> missionListDTO = missionList.stream()
                .map(StoreConverter::toMissionDTO)
                .collect(Collectors.toList());

        return StoreResponse.MissionListDTO.builder()
                .missionList(missionListDTO)
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionListDTO.size())
                .build();
    }

}
