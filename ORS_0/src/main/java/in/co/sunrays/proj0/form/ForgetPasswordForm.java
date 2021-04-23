package in.co.sunrays.proj0.form;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import in.co.sunrays.proj0.dto.BaseDTO;
import in.co.sunrays.proj0.dto.UserDTO;

/**
 * Contains Forget Password form elements and their declarative input
 * validations.
 * 
 * @author Iterator
 * @version 1.0 Copyright (c) Iterator
 */
public class ForgetPasswordForm extends BaseForm {

	/**
	 * email of FrogetPassword
	 *
	 */
	@NotEmpty
	@Email
	private String login;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Override
	public BaseDTO getDto() {
		UserDTO dto = new UserDTO();
		dto.setEmailId(login);
		return dto;
	}

	@Override
	public void populate(BaseDTO bDto) {
		UserDTO dto = (UserDTO) bDto;
		login = dto.getEmailId();

	}
}
