package umc.spring.validation.validator;

import umc.spring.validation.annotation.SinceNowDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class DateSinceNowValidator implements ConstraintValidator<SinceNowDate, LocalDate> {

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        return false;
    }

}
