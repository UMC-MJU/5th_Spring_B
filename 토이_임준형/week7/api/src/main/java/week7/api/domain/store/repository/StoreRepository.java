package week7.api.domain.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import week7.api.domain.store.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
