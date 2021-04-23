package in.co.sunrays.proj0.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ST_ROLE")
public class RoleDTO extends BaseDTO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int ADMIN=1;
	public static final int STUDENT=2;
	public static final int FACULTY=4;
	//public static final int KIOSK=4;
	public static final int COLLEGE=3;
	
	@Column(name="NAME" ,length=255)
	private String name;
	
	@Column(name="DESCRIPTION",length=255)
	private String description;
	
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

	public String getKey() {
		// TODO Auto-generated method stub
		return id+"";
	}

	public String getValue() {
		// TODO Auto-generated method stub
		return name;
	}

	

}
