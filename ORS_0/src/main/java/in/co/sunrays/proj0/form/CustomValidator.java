package in.co.sunrays.proj0.form;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomValidator implements ConstraintValidator<Custom, String>{
	private String regex;
	
	public void initialize(Custom constraintAnnotation) {
		
		this.regex=constraintAnnotation.regex();	
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value == null||value.toString().trim()==""){
			context.disableDefaultConstraintViolation();
			return true;
		} else if((value!=null||value.toString().trim()!="")&&value.matches(regex)) return true;
        //return false if nothing matches the input
        else return false;
	}

}
