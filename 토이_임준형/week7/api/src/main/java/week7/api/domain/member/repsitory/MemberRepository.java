package week7.api.domain.member.repsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import week7.api.domain.member.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
