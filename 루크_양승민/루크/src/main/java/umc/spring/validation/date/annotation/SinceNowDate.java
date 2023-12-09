package umc.spring.validation.date.annotation;

import umc.spring.validation.date.validator.DateSinceNowValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;
import java.time.LocalDate;

@Documented
@Constraint(validatedBy = DateSinceNowValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface SinceNowDate {

    String message() default "현재 날짜 이전일 수 없습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
