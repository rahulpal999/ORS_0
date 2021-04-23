package in.co.sunrays.proj0.form;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {
private String regex;
	public void initialize(Phone paramA) {
this.regex=paramA.regex();
	}

	public boolean isValid(String phoneNo, ConstraintValidatorContext ctx) {
	
		if(phoneNo == null||phoneNo.toString().trim()==""){
			ctx.disableDefaultConstraintViolation();
			return true;
		}
		/*
		 * //validate phone numbers of format "1234567890" if
		 * (phoneNo.matches("\\d{10}")) return true; //validating phone number with -, .
		 * or spaces else if(phoneNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}"))
		 * return true; //validating phone number with extension length from 3 to 5 else
		 * if(phoneNo.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) return true;
		 * //validating phone number where area code is in braces () else
		 * if(phoneNo.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) return true;
		 */
        else if((phoneNo!=null||phoneNo.toString().trim()!="")&&phoneNo.matches(regex)) return true;
        //return false if nothing matches the input
        else return false;
	}

}

