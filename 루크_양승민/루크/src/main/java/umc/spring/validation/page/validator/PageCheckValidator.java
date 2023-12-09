package umc.spring.validation.page.validator;

import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.validation.page.annotation.CheckPage;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PageCheckValidator implements ConstraintValidator<CheckPage, Integer>{

    @Override
    public void initialize(CheckPage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        boolean isValid = value > 0;

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.PAGE_NEGATIVE_BAD_REQUEST.toString())
                    .addConstraintViolation();
        }

        return isValid;
    }

}
