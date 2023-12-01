package week7.api.domain.store.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import week7.api.domain.base.BaseEntity;
import week7.api.domain.domain.Address;
import week7.api.domain.review.domain.Review;

@Entity
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "store")
    private List<Review> reviewList = new ArrayList<>();

}
