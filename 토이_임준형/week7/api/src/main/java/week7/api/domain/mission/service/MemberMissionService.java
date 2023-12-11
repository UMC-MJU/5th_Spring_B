package week7.api.domain.mission.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import week7.api.domain.member.domain.MemberMission;

public interface MemberMissionService {
    MemberMission save(MemberMission memberMission);

    Page<MemberMission> findAllByMemberId(Pageable pageable);
}
