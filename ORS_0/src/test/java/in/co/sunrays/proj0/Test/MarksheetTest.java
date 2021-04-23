package in.co.sunrays.proj0.Test;

import java.sql.Timestamp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import in.co.sunrays.proj0.dto.MarksheetDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;
import in.co.sunrays.proj0.service.MarksheetServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/Dispatcher-servlet.xml")
public class MarksheetTest {
	@Autowired
MarksheetServiceInt service;
	@Test
public void add(){
	MarksheetDTO dto=new MarksheetDTO();
	dto.setRollNo("cs01");
	dto.setStudentId(1);
	dto.setPhysics("65");
	dto.setChemistry("65");
	dto.setMaths("65");
	dto.setCreatedBy("root");
	dto.setModifiedBy(dto.getCreatedBy());
	dto.setModifiedDateTime(new Timestamp(System.currentTimeMillis()));
	dto.setModifiedDateTime(dto.getCreatedDateTime());
	
	try {
		long pk=service.add(dto);
		System.out.println("Add======"+pk);
	} catch (DuplicateRecordException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
