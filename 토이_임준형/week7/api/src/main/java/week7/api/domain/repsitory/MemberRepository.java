package week7.api.domain.repsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import week7.api.domain.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
