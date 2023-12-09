package umc.spring.validation.date.validator;

import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.validation.date.annotation.SinceNowDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

@Component
public class DateSinceNowValidator implements ConstraintValidator<SinceNowDate, LocalDate> {

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        boolean isValid = value.isAfter(LocalDate.now());

        if(!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.UNTIL_NOW_DATE_BAD_REQUEST.toString())
                    .addConstraintViolation();
        }

        return isValid;
    }

}
