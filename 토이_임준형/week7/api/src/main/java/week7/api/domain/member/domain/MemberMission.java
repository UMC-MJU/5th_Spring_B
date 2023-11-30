package week7.api.domain.member.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import week7.api.domain.base.BaseEntity;
import week7.api.domain.domain.Mission;
import week7.api.domain.domain.Status;
import week7.api.domain.member.domain.Member;

@Entity
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    @Enumerated(EnumType.STRING)
    private Status missionStatus;

    public void mappingMember(Member member) {
        this.member = member;
        member.getMemberMissionList().add(this);
    }

    public void mappingMission(Mission mission) {
        this.mission = mission;
        mission.getMemberMissionList().add(this);
    }
}
