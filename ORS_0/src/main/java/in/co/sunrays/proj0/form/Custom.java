package in.co.sunrays.proj0.form;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Documented
@Constraint(validatedBy = CustomValidator.class)
@Target( {ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)

public  @interface Custom {
	 String message() default "{in.co.sunrays.proj0.form.CustomValidator."+"message}";
	                           //{in.co.sunrays.proj0.form.PhoneValidator."+"message}
	                         // to read message from properties file
     String regex() default "\\d{10}";
	    Class<?>[] groups() default {};
	     
	    Class<? extends Payload>[] payload() default {};
}
