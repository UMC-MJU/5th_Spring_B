package week7.api.domain.food.domain;

import javax.persistence.Entity;
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
import week7.api.domain.member.domain.Member;

@Entity
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Food extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String name;

    public void mappingMember(Member member) {
        this.member = member;
        member.getFoodList().add(this);
    }
}
