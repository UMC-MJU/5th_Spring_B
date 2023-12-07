package umc.spring.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.validation.annotation.UntilNowDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class DateUntilNowValidator implements ConstraintValidator<UntilNowDate, LocalDate> {

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {

        boolean isValid = value.isBefore(LocalDate.now());

        if(!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.UNTIL_NOW_DATE_BAD_REQUEST.toString())
                    .addConstraintViolation();
        }

        return isValid;
    }
}
