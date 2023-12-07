package umc.study.validation.validator;

import org.springframework.stereotype.Component;
import umc.study.validation.annotation.ValidPage;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class PageValidator implements ConstraintValidator<ValidPage, Integer> {
    @Override
    public boolean isValid(Integer page, ConstraintValidatorContext context) {
        if (page == null || page < 1) {
            return false;
        }

        return true;
    }
}
