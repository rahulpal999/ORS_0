package in.co.sunrays.proj0.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Student DTO classes
 * 
 * @author SUNRAYS Technologies
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 * 
 */
@Entity
@Table(name="ST_STUDENT")
public class StudentDTO extends BaseDTO {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * CollegeId of Student
     */
	@Column(name="COLLEGE_ID")
    private long collegeId;
    /**
     * College name of Student
     */
	@Transient
	private String collegeName;

     /**
     * First Name of Student
     */
	@Column(name="FIRST_NAME")
    private String firstName;
    /**
     * Last Name of Student
     */
	@Column(name="LAST_NAME")
    private String lastName;
    
	/**
     * Gender of Student
     */
	@Column(name="GENDER")
    private String gender;
	/**
     * Date of Birth of Student
     */
	@Column(name="DOB")
    private Date dob;
	/**
     * Email of Student
     */
	@Column(name="EMAIL_ID")
    private String emailId;
    
	/**
     * Mobileno of Student
     */
	@Column(name="MOBILE_NO")
    private String mobileNo;
   
    /**
     * accessor
     */
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
    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }
    public String getMobileNo() {
        return mobileNo;
    }
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
    public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
    public String getEmail() {
        return emailId;
    }
    public void setEmail(String emailId) {
        this.emailId = emailId;
    }
    public Long getCollegeId() {
        return collegeId;
    }
    public void setCollegeId(Long collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }
    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }
	public String getKey() {
		// TODO Auto-generated method stub
		return id+"";
	}
	public String getValue() {
		// TODO Auto-generated method stub
		return firstName+" "+lastName;
	}
  
}

