package in.co.sunrays.proj0.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import in.co.sunrays.proj0.dto.FacultyDTO;
import in.co.sunrays.proj0.dto.UserDTO;
/**
 * Faculty Data Access Object provides Database CRUD operations. It is implemented
 * by plain Hibernate 3 API with Spring ORM.
 * 
 * All methods propagate unchecked DataAccessException. It is a generic
 * exception handling provided by Spring-DAO.
 * 
 * If DataAccessException is propagated from method then declarative transaction
 * is rolled back by Spring AOP.
 * 
 * This is plain Hibernate 3 API implementation of DAO
 * 
 * @author Iterator Copyright (c) Iterator
 */
@Repository
public class FacultyDAOHibImpl implements FacultyDAOInt {
	@Autowired
	private SessionFactory sessionfactory = null;
	private static Logger log = Logger.getLogger(FacultyDAOHibImpl.class);
	
	public long add(FacultyDTO dto) throws DataAccessException {
		log.debug("Faculty Dao Add Started");
		long pk = 0;
		pk = (Long) sessionfactory.getCurrentSession().save(dto);
		log.debug("Faculty Dao Add End");
		return pk;
	}

	public void update(FacultyDTO dto) throws DataAccessException {
		log.debug("Faculty Dao Update Started");
		sessionfactory.getCurrentSession().update(dto);
		log.debug("Faculty Dao Update End");
		
	}

	public void delete(long id) throws DataAccessException {
		log.debug("Faculty Dao Delete Started");
		FacultyDTO dto = findByPK(id);
		sessionfactory.getCurrentSession().delete(dto);
		log.debug("Faculty Dao Delete End");
	}

	public FacultyDTO findByEmail(String login) throws DataAccessException {
		log.debug("User Dao FindByLogin Started");
		FacultyDTO dto = null;
		List list = sessionfactory.getCurrentSession().createCriteria(FacultyDTO.class)
				.add(Restrictions.eq("emailId", login)).list();
		if (list.size() == 1) {
			dto = (FacultyDTO) list.get(0);
		}
		log.debug("User Dao FindByLogin End");
		return dto;
	}

	public FacultyDTO findByPK(long pk) throws DataAccessException {
		log.debug("Faculty Dao FindByEmail Started");
		FacultyDTO dto = null;
		dto = (FacultyDTO) sessionfactory.getCurrentSession().get(FacultyDTO.class, pk);
		log.debug("Faculty Dao FindByEmail End");
		return dto;
	}

	public List<FacultyDTO> search(FacultyDTO dto, int pageNo, int pageSize) throws DataAccessException {
		log.debug("Faculty Dao Search Started");
		List list = null;
		Criteria criteria = sessionfactory.getCurrentSession().createCriteria(FacultyDTO.class);
		if (dto != null) {
			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				criteria.add(Restrictions.like("firstName", dto.getFirstName() + "%"));
			}
			if (dto.getLastName() != null && dto.getLastName().length() > 0) {
				criteria.add(Restrictions.like("lastName", dto.getLastName() + "%"));
			}
			if (dto.getEmailId() != null && dto.getEmailId().length() > 0) {
				criteria.add(Restrictions.like("emailId", dto.getEmailId() + "%"));
			}
			
			if (dto.getGender() != null && dto.getGender().length() > 0) {
				criteria.add(Restrictions.like("gender", dto.getGender() + "%"));
			}
			if (dto.getDob() != null && dto.getDob().getDate() > 0) {
				criteria.add(Restrictions.eq("dob", dto.getDob()));
			}

		}

		// if page size is greater than zero the apply pagination
		if (pageSize > 0) {
			criteria.setFirstResult((pageNo - 1) * pageSize);
			criteria.setMaxResults(pageSize);
		}

		list = criteria.list();
		log.debug("Faculty Dao Search End");
		return list;

	}

	public List<FacultyDTO> search(FacultyDTO dto) throws DataAccessException {
		// TODO Auto-generated method stub
		return search(dto,0,0);
	}
}
