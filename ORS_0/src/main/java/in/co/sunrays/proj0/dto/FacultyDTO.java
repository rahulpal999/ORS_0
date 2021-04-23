package in.co.sunrays.proj0.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name="ST_FACULTY")
public class FacultyDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * college id
	 */
	
	@Column(name="COLLEGE_ID")
	private long collegeId;
	/**
	 * college name
	 */
	@Transient
	private String collegeName;
	/**
	 * course id
	 */
	@Column(name="COURSE_ID")
	private long courseId;
	/**
	 * course name
	 */
	@Transient
	private String courseName;
	/**
	 * subject id
	 */
	@Column(name="SUBJECT_ID")
	private long subjectId;
	/**
	 * subject name
	 */
	@Transient
	private String subjectName;
	/**
	 * faculty first name
	 */
	@Column(name="FIRST_NAME",length=255)
	private String firstName;
	/**
	 * faculty last name
	 */
	@Column(name="LAST_NAME")
	private String lastName;
	/**
	 * gender
	 */
	@Column(name="GENDER")
	private String Gender;	
	/**
	 * date of birth
	 */
	@Column(name="DOB")
	private Date dob;
	
	/**
	 * mobile number
	 */
	@Column(name="MOBILE_NUMBER")
	private String mobileNo;

	/**
	 * faulty email id
	 */
	@Column(name="EMAIL_ID",length=255)
	private String emailId;

	

	
	

	/**
	 * accessors
	 */

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public long getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(long collegeId) {
		this.collegeId = collegeId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
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

	
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}
	public String getKey() {
		return id + "";
	}

	public String getValue() {
		return firstName + " " + lastName;
	}

}
