package in.co.sunrays.proj0.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="ST_SUBJECT")
public class SubjectDTO extends BaseDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Id foreign key course
	 */
	@Column(name="COURSE_ID")
	private long courseId;
	
	/**
	 * name of course
	 */
	@Transient
	private String courseName;

	/**
     *  Name of Subject
     */	
	@Column(name="NAME")
	private String name;
	/**
	 * semester in subjects 
	 */
	@Column(name="SEMESTER")
	private String semester;
	/**
	 * Description of subjects
	 */
	@Column(name="DESCRIPTION")
	private String description;
	

	/**
	 *accessor 
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getKey() {
		// TODO Auto-generated method stub
		return id+"";
	}
	public String getValue() {
		// TODO Auto-generated method stub
		return name;
	}
	
	
	

}
