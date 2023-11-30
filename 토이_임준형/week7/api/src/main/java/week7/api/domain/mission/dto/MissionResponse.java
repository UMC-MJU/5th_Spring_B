package week7.api.domain.mission.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class MissionResponse {
    private Long storeId;
    private Long missionId;
    private Long memberId;
    private String content;
}
