package in.co.sunrays.proj0.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name="ST_TIMETABLE")
public class TimeTableDTO extends BaseDTO{


	
	private static final long serialVersionUID = 1L;
	/**
	 * Course Id
	 */
	@Column(name="COURSE_ID")
	private long courseId;
	/**
	 * Course Name
	 */
	@Column(name="COURSE_NAME")
	private String courseName;
	/**
	 * Subject Id
	 */
	@Column(name="SUBJECT_ID")
	private long subjectId;
	/**
	 * Subject Name
	 */
	@Column(name="SUBJECT_NAME")
	private String subjectName;
	/**
	 * Semester
	 */
	@Column(name="SEMESTER")
	private String semester;
	/**
	 * Exam Date
	 */
	@Column(name="EXAM_DATE")
	private Date examDate;
	/**
	 * Exam Time
	 */
	@Column(name="Exam_TIME")
	private String time;

	/**
	 * Accessors
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

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getKey() {
		// TODO Auto-generated method stub
		return id + "";
	}

	public String getValue() {
		// TODO Auto-generated method stub
		return examDate + "";
	}
}
