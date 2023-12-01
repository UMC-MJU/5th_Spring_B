package week7.api.domain.mission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import week7.api.domain.member.domain.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
}
