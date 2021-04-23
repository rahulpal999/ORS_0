package in.co.sunrays.proj0.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ST_USER")
public class UserDTO extends BaseDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "FIRST_NAME", length = 255)
	private String firstName;

	@Column(name = "LAST_NAME", length = 255)
	private String lastName;

	@Column(name = "GENDER", length = 255)
	private String gender;

	@Column(name = "EMAIL_ID", length = 255)
	private String emailId;

	@Column(name = "PASSWORD", length = 255)
	private String password;

	@Transient
	private String confirmPassword;

	@Column(name = "ROLE_ID")
	private long roleId;

	@Column(name = "ROLE_NAME", length = 255)
	private String roleName;

	@Column(name = "DOB")
	private Date dob;
	
	private String mobileNo;

	@Column(name="MOBILE_NO")
	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getKey() {
		
		return id+"";
	}

	public String getValue() {
		
		return firstName+" "+lastName;
	}

}
