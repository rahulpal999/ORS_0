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

import in.co.sunrays.proj0.dto.RoleDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;
import in.co.sunrays.proj0.service.RoleServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/Dispatcher-servlet.xml")
public class RoleTest {

	@Autowired
	RoleServiceInt roleServiceImpl;

	@Test
	public void add() {
		RoleDTO dto = new RoleDTO();
		dto.setName("Admin");
		dto.setDescription("Application Administratore");
		dto.setCreatedBy("root");
		dto.setModifiedBy("root");
		dto.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
		dto.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));

		try {
			long pk = roleServiceImpl.add(dto);
			System.out.println(pk);
		} catch (DuplicateRecordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Ignore
	public void update() {
		RoleDTO dto = new RoleDTO();
		dto.setId(1);
		dto.setName("Admin");
		dto.setDescription("System Administratore");
		dto.setCreatedBy("root");
		dto.setModifiedBy("root");
		dto.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
		dto.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
		System.out.println("Role Update Success");
		try {
			roleServiceImpl.update(dto);
		} catch (DuplicateRecordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Ignore
	public void findByPk() {
		RoleDTO dto = roleServiceImpl.findById(1);
		System.out.println("Role find By Id Success" + dto.getName());
	}

	@Ignore
	public void findByName() {
		RoleDTO dto = roleServiceImpl.findByName("Admin");
		System.out.println("Role Find by name success" + dto.getId());
	}

	@Ignore
	public void search() {
		RoleDTO dto = new RoleDTO();
		List list = roleServiceImpl.search(dto);
		System.out.println("Role Search(RoleDTO) =" + list.size());
	}

	@Ignore
	public void searchPagination() {
		RoleDTO dto = new RoleDTO();
		// dto.setId(1);
		dto.setName("Admin");
		List list = roleServiceImpl.search(dto, 1, 10);
		System.out.println("Role Search(RoleDTO,pageNo,pageSize) =" + list.size());
	}

	@Ignore
	public void delete() {
		roleServiceImpl.delete(1);
		System.out.println("Role Delete Success");
	}
}
