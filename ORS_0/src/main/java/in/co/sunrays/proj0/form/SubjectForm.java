package in.co.sunrays.proj0.form;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.sunrays.proj0.dto.BaseDTO;
import in.co.sunrays.proj0.dto.SubjectDTO;

/**
 * Contains Subject form elements and their declarative input validations.
 * 
 * @author Iterator
 * @version 1.0 Copyright (c) Iterator
 */
public class SubjectForm extends BaseForm{
	
	/**
	 * name of SubjectForm
	 */
		@NotEmpty
		private String name;
		
	/**
	 * courseId of SubjectForm
	 */		
		@Min(value=1,message="{Min.form.courseId}")
		private long courseId;
		
	/**
	 * courseName of SubjectForm
	 */
	
		private String courseName;
		
	/**
	 * description of SubjectForm
	 */
		@NotEmpty
		private String description;

		

		public String getSubjectName() {
			return name;
		}

		public void setSubjectName(String name) {
			this.name = name;
		}

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

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		@Override
		public BaseDTO getDto() {
		SubjectDTO dto=new SubjectDTO();
		dto.setId(id);
		dto.setName(name);
        dto.setCourseId(courseId);
        /*dto.setCourseName(courseName);*/
        dto.setDescription(description);
        dto.setCreatedDateTime(new Timestamp(new Date().getTime()));
        dto.setModifiedDateTime(new Timestamp(new Date().getTime()));
		
		return dto;
		}
		
		@Override
		public void populate(BaseDTO bDto) {
		SubjectDTO dto=(SubjectDTO) bDto;
		id=dto.getId();
		name=dto.getName();
		courseId=dto.getCourseId();
		description=dto.getDescription();
		createdBy = dto.getCreatedBy();
	    modifiedBy = dto.getModifiedBy();
	    if(dto.getCreatedDateTime()!=null)
	    createdDatetime = dto.getCreatedDateTime().getTime();
	    if(dto.getModifiedDateTime()!=null)
	    modifiedDatetime = dto.getModifiedDateTime().getTime();
		}

}

