package week7.api.domain.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import week7.api.domain.food.domain.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {

}
