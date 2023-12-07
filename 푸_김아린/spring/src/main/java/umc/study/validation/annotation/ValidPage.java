package umc.study.validation.annotation;

import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidPage {
    String message() default "Invalid page number";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
