package week7.api.domain.mission.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class MissionCreateRequest {
    private Long storeId;
    private String content;
}
