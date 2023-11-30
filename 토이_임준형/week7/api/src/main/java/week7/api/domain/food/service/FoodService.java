package week7.api.domain.food.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import week7.api.domain.food.repository.FoodRepository;

@Service
@RequiredArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;

    public boolean existsById(Long id) {
        return foodRepository.existsById(id);
    }
}
