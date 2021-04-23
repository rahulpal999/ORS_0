package in.co.sunrays.proj0.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ST_COURSE")
public class CourseDTO extends BaseDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Course Name
	 */
	@Column(name="NAME")
	private String name;
	/**
	 * Description of course
	 */
	@Column(name="DESCRIPTION")
	private String description;
	/**
	 * duration of course
	 */
	@Column(name="DURATION")
	private String duration;
	
	/**
	 * 
	 * accessors
	 */
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
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
