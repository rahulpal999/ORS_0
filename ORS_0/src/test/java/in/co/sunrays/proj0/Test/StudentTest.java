package in.co.sunrays.proj0.Test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import in.co.sunrays.proj0.dto.StudentDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;
import in.co.sunrays.proj0.service.StudentServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/Dispatcher-servlet.xml")
public class StudentTest {
@Autowired
	StudentServiceInt service;
	@Ignore
public void  add() throws ParseException{
	StudentDTO dto=new StudentDTO();
	dto.setFirstName("Raj");
	dto.setLastName("Kumar");
	dto.setCollegeId(1l);
	dto.setGender("M");
	dto.setMobileNo("8635986535");
	dto.setDob(new SimpleDateFormat("dd/MM/yyyy").parse("05/05/1995"));
	dto.setEmail("raj@gmail.com");
	dto.setCreatedBy("root");
	dto.setModifiedBy("root");
	dto.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
	dto.setModifiedDateTime(dto.getCreatedDateTime());
	try {
		long pk=service.add(dto);
		System.out.println("Add Success="+pk);
	} catch (DuplicateRecordException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
@Ignore
public void  update() throws ParseException{
	
	StudentDTO dto=new StudentDTO();
	dto.setFirstName("Raj");
	dto.setId(1);
	dto.setLastName("Kumar");
	dto.setCollegeId(1l);
	dto.setGender("M");
	dto.setMobileNo("8635986535");
	dto.setDob(new SimpleDateFormat("dd/MM/yyyy").parse("05/05/1995"));
	dto.setEmail("raj@gmail.com");
	dto.setCreatedBy("root");
	dto.setModifiedBy("root");
	dto.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
	dto.setModifiedDateTime(dto.getCreatedDateTime());
try {
	service.update(dto);
	System.out.println("Update Success");
} catch (DuplicateRecordException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

}
@Ignore
public void  delete(){}
@Ignore
public void  findByPk(){
	StudentDTO dto=	service.findById(1);
System.out.println("find by pk Success "+dto.getFirstName());
}
@Ignore
public void  findByEmail(){
	
	StudentDTO dto=service.findByEmail("raj@gmail.com");
System.out.println("Find by Email Success "+dto.getFirstName());
}
@Test
public void  searchPagination(){
	StudentDTO dto=new StudentDTO();
	//dto.setId(1);
	dto.setCollegeId(1l);
	//dto.setFirstName("raj");
	//dto.setLastName("Kumar");
	
List<StudentDTO> list=	service.search(dto, 1, 10);
System.out.println("Search pagination success "+list.size());
	
}
@Ignore
public void  search(){
	StudentDTO dto=new StudentDTO();
	
List<StudentDTO> list=	service.search(dto);
System.out.println("Search  success "+list.size());
}

}
