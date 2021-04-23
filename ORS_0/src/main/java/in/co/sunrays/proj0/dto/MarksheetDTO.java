package in.co.sunrays.proj0.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ST_MARKSHEET")
public class MarksheetDTO extends BaseDTO{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * ID of Student
     */
	@Column(name="STUDENT_ID",length=255)
    private long studentId;
     /**
     * Rollno of Student
     */
	@Column(name="ROLL_NUMBER")
    private String rollNo;
    
    /**
     * Name of Student
     */
	@Column(name="STUDENT_NAME")
    private String name;
    /**
     * Physics marks of Student
     */
	@Column(name="PHYSICS")
    private String physics;
    /**
     * Chemistry marks of Student
     */
	@Column(name="CHEMISTRY")
    private String chemistry;
    /**
     * Mathematics marks of Student
     */
	@Column(name="MATHS")
    private String maths;
	
	
	/**
	 * Accessors
	 */
	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhysics() {
		return physics;
	}
	public void setPhysics(String physics) {
		this.physics = physics;
	}
	public String getChemistry() {
		return chemistry;
	}
	public void setChemistry(String chemistry) {
		this.chemistry = chemistry;
	}
	public String getMaths() {
		return maths;
	}
	public void setMaths(String maths) {
		this.maths = maths;
	}
	public String getKey() {
		// TODO Auto-generated method stub
		return id+"";
	}
	public String getValue() {
		// TODO Auto-generated method stub
		return rollNo;
	}

	
	
}
