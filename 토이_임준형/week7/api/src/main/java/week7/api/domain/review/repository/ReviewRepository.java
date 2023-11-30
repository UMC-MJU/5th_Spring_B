package week7.api.domain.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import week7.api.domain.review.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
