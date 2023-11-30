package week7.api.domain.domain;

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

@Entity
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ImageUrl extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "image_url_id")
    private Review review;

    private String imageUrl;

    public void mappingReview(Review review) {
        this.review = review;
        review.getImageUrlList().add(this);
    }
}
