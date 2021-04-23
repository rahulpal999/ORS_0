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

import in.co.sunrays.proj0.dto.SubjectDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;
import in.co.sunrays.proj0.service.SubjectServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/Dispatcher-servlet.xml")
public class SubjectTest {
	@Autowired
	SubjectServiceInt service;

	@Ignore
	public void add(){
		SubjectDTO dto=new SubjectDTO();
		dto.setName("cse");
		dto.setCourseId(1);
		dto.setSemester("I");
		dto.setDescription("computer science and engineering");
		dto.setCreatedBy("root");
		dto.setModifiedBy(dto.getCreatedBy());
		dto.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
		dto.setModifiedDateTime(dto.getCreatedDateTime());
	try {
		long pk=service.add(dto);
		System.out.println("=========Subject Add Success====== "+pk);
	} catch (DuplicateRecordException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	@Ignore
	public void update(){
		SubjectDTO dto=new SubjectDTO();
		dto.setName("cse");
		dto.setId(1);
		dto.setCourseId(1);
		dto.setSemester("I");
		dto.setDescription("computer science and engineering");
		dto.setCreatedBy("Root");
		dto.setModifiedBy(dto.getCreatedBy());
		dto.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
		dto.setModifiedDateTime(dto.getCreatedDateTime());
		try {
			service.update(dto);
			System.out.println("=======Subject Update Success=========");
		} catch (DuplicateRecordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}public void delete(){
	}
	@Ignore
	public void findByPk(){
		SubjectDTO dto=service.findById(1);
		System.out.println("=======Subject findByPk success===="+dto.getName() );
	}
	@Ignore
	public void findByName(){
		SubjectDTO dto=service.findByName("cse");
		System.out.println("=======Subject findByName Success======"+dto.getId());
	}
	@Ignore
	public void search(){
		SubjectDTO dto=new SubjectDTO();
		List<SubjectDTO> l=service.search(dto);
		System.out.println("==========Subject search success====="+l.size());
	}
	@Test
	public void searchPage(){
		SubjectDTO dto=new SubjectDTO();
		//dto.setId(1);
	dto.setCourseId(1);
		//dto.setName("cse");
		List<SubjectDTO> l=service.search(dto,1,10);
		
	System.out.println("==========Subject searchPagination success====="+l.size());
	}
}
