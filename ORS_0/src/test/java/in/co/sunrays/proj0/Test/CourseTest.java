package in.co.sunrays.proj0.Test;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import in.co.sunrays.proj0.dto.CourseDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;
import in.co.sunrays.proj0.service.CourseServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/Dispatcher-servlet.xml")
public class CourseTest {

	@Autowired
	CourseServiceInt service;
	@Ignore
	public void add(){
		CourseDTO dto=new CourseDTO();
		dto.setName("BE");
		dto.setDuration("4 YEARS");
		dto.setDescription("Bechlors of Engineering");
		dto.setCreatedBy("root");
		dto.setModifiedBy("root");
		dto.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
		dto.setModifiedDateTime(dto.getCreatedDateTime());
			try {
			long pk=service.add(dto);
				System.out.println("Course Add Success===="+pk );
			} catch (DuplicateRecordException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}
	@Ignore
public void update(){
	CourseDTO dto=new CourseDTO();
	dto.setId(1);
	dto.setName("BE");
	dto.setDuration("4 YEAR");
	dto.setDescription("Bechlors of Engineering");
	dto.setCreatedBy("root");
	dto.setModifiedBy("root");
	dto.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
	dto.setModifiedDateTime(dto.getCreatedDateTime());
try {
	service.update(dto);
	System.out.println("=========Course Update Success====" );
} catch (DuplicateRecordException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}	
}
	@Test
public void delete(){
	service.delete(1);
	System.out.println("=========Course Delete Success======");
}
@Ignore
public void findById(){
CourseDTO dto=service.findById(1);
System.out.println("========Course FindByPk Success======="+dto.getName());
}
@Ignore
public void findByName(){
	CourseDTO dto=service.findByName("BE");
	System.out.println("========Course FindByName Success======="+dto.getId());
}
@Ignore
public void search(){
		CourseDTO dto=new CourseDTO();
		List<CourseDTO> l=service.search(dto);
System.out.println("========Course Search success===== "+l.size());
	}
@Ignore
public void searchPage(){
		CourseDTO dto=new CourseDTO();
		//dto.setId(1);
		//dto.setName("BE");
		List<CourseDTO> l=service.search(dto,1,10);
System.out.println("========Course SearchPagination success===== "+l.size());
	}
}
