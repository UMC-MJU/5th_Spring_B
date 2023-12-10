package week7.api.domain.review.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import week7.api.domain.review.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findAllByStoreId(Long storeId, Pageable pageable);
    Page<Review> findAllByMemberId(Long memberId, Pageable pageable);
}
