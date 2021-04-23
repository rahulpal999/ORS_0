package in.co.sunrays.proj0.form;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class LoginForm extends BaseForm
{
	/**
	 * email of LoginForm
	 */
	@NotEmpty
	@Email
	private String emailId;
	
	/**
	 * password of LoginForm
	 */
	@NotEmpty
	private String password;
	
	private String uri=null;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUri() {
		
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
	
}

