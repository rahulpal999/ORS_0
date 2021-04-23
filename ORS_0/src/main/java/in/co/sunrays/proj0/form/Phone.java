package in.co.sunrays.proj0.form;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = PhoneValidator.class)
@Target( {ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public  @interface Phone {
	 String message() default "{in.co.sunrays.proj0.form.PhoneValidator."+"message}";
	                           //{in.co.sunrays.proj0.form.PhoneValidator."+"message}
	                         // to read message from properties file
     String regex() default "\\d{10}";
	    Class<?>[] groups() default {};
	     
	    Class<? extends Payload>[] payload() default {};
}
