package in.co.sunrays.proj0.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.sunrays.proj0.dto.CourseDTO;

/**
 * The Class CourseDAOHibImpl
 *
 */
@Repository
public class CourseDAOHibImpl implements CourseDAOInt {

	/** The sessionfactory. */
	@Autowired
	private	SessionFactory sessionfactory = null;
	
	/** The log. */
	private static Logger log = Logger.getLogger(CourseDAOHibImpl.class);
	
	public long add(CourseDTO dto) {
		log.debug("CourseDAOHibImpl Add Started");
		long pk = (Long) sessionfactory.getCurrentSession().save(dto);
		log.debug("CourseDAOHibImpl Add End");
		return pk;
	}

	public void update(CourseDTO dto) {
		log.debug("CourseDAOHibImpl Update Started");
		sessionfactory.getCurrentSession().update(dto);
		log.debug("CourseDAOHibImpl Update End");
		
	}

	public void delete(long id) {
		log.debug("CourseDAOHibImpl Delete Started");
		CourseDTO dto = findByPK(id);
		sessionfactory.getCurrentSession().delete(dto);
		log.debug("CourseDAOHibImpl Delete End");
		
	}

	public CourseDTO findByName(String courseName) {
		log.debug("CourseDAOHibImpl Find by Name Started");
		CourseDTO dto = null;
		List list = sessionfactory.getCurrentSession().createCriteria(CourseDTO.class).add(Restrictions.eq("name", courseName)).list();
		if (list.size() == 1) {
			dto = (CourseDTO) list.get(0);
		}
		log.debug("CourseDAOHibImpl Find by Name Ended");
		return dto;
	}

	public CourseDTO findByPK(long pk) {
		log.debug("CourseDAOHibImpl Find by PK Started");
		CourseDTO dto = null;
		dto = (CourseDTO) sessionfactory.getCurrentSession().get(CourseDTO.class, pk);
		log.debug("CourseDAOHibImpl Find by PK Ended");
		return dto;
	}

	public List<CourseDTO> search(CourseDTO dto, int pageNo, int pageSize) {
		log.debug("CourseDAOHibImpl search Started");
		Criteria criteria = sessionfactory.getCurrentSession().createCriteria(CourseDTO.class);
		if(dto!=null)
		{
			
		
		if (dto.getId() > 0) {
            criteria.add(Restrictions.eq("id", dto.getId()));
        }
        if (dto.getName() != null && dto.getName().length() > 0) {
            criteria.add(Restrictions.like("name", dto.getName() + "%"));
        }
        if (dto.getDescription() != null && dto.getDescription().length() > 0)
        {
            criteria.add(Restrictions.like("description", dto.getDescription() + "%"));
        }
		}
        // if page size is greater than zero the apply pagination
        if (pageSize > 0) {
            criteria.setFirstResult(((pageNo - 1) * pageSize));
            criteria.setMaxResults(pageSize);
        }
		List list = criteria.list();
		log.debug("CourseDAOHibImpl search End");
		return list;

	}

	public List<CourseDTO> search(CourseDTO dto) {
		// TODO Auto-generated method stub
		return search(dto,0,0);
	}

}
