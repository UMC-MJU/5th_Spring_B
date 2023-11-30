package week7.api.domain.mission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import week7.api.domain.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}
