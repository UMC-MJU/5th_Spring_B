package umc.spring.service.foodCategoryService.base;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.repository.FoodCategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodCategoryBaseServiceImpl implements FoodCategoryBaseService {

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    public boolean isExistedFoodCategories(List<Long> value){
        return value.stream().allMatch(foodCategoryRepository::existsById);
    }

}
