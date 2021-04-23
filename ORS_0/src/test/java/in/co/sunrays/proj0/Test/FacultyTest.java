package in.co.sunrays.proj0.Test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import in.co.sunrays.proj0.dto.FacultyDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;
import in.co.sunrays.proj0.service.FacultyServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/Dispatcher-servlet.xml")
public class FacultyTest {
	@Autowired
	FacultyServiceInt service;
	@Ignore
public void add() throws ParseException{
	FacultyDTO dto=new FacultyDTO();
	dto.setCollegeId(1);
	dto.setSubjectId(1);
	dto.setCourseId(1);
	dto.setFirstName("Manish");
	dto.setLastName("Puspad");
	dto.setEmailId("manish@gmail.com");
	dto.setGender("M");
	dto.setDob(new SimpleDateFormat("dd/MM/yyyy").parse("05/05/1990"));
	dto.setMobileNo("8968986986");
	//dto.setQualification("BE Mtech.");
	dto.setCreatedBy("root");
	dto.setModifiedBy("root");
	dto.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
	dto.setModifiedDateTime(dto.getCreatedDateTime());
	try {
		service.add(dto);
	} catch (DuplicateRecordException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
	@Ignore
	public void update() throws ParseException{
		FacultyDTO dto=new FacultyDTO();
		dto.setId(1);
		dto.setCollegeId(1);
		dto.setSubjectId(1);
		dto.setCourseId(1);
		dto.setFirstName("Manish");
		dto.setLastName("Puspad");
		dto.setEmailId("manish@gmail.com");
		dto.setGender("M");
		dto.setDob(new SimpleDateFormat("dd/MM/yyyy").parse("05/05/1990"));
		dto.setMobileNo("8968986986");
		//dto.setQualification("BE Mtech.");
		dto.setCreatedBy("root");
		dto.setModifiedBy("root");
		dto.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
		dto.setModifiedDateTime(dto.getCreatedDateTime());
try {
	service.update(dto);
} catch (DuplicateRecordException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}		
		
	}
@Ignore
	public void findByPk(){
	FacultyDTO dto= service.findByPK(1);
System.out.println("find By Pk==="+dto.getId());
}	
@Ignore
public void findByEmail(){
	FacultyDTO dto= service.findByEmail("manish@gmail.com");
			System.out.println("find By email==="+dto.getId());
}
@Test
public void delete(){
	service.delete(1);
	System.out.println("delete success");
}
}
