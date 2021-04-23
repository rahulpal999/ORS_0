package in.co.sunrays.proj0.dao;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.sunrays.proj0.dto.CourseDTO;
import in.co.sunrays.proj0.dto.SubjectDTO;
import in.co.sunrays.proj0.dto.TimeTableDTO;
/**
 * TimeTable Data Access Object provides Database CRUD operations. It is implemented
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
public class TimeTableDAOHibImpl implements TimeTableDAOInt{
	@Autowired
	private SessionFactory sessionfactory = null;
    @Autowired
	CourseDAOInt cDao;
	@Autowired
	SubjectDAOInt sDao;
	private static Logger log = Logger.getLogger(TimeTableDAOHibImpl.class);

	public long add(TimeTableDTO dto) {
		log.debug("TimeTable Dao Add Started");
		long pk = 0;
		CourseDTO cdto= cDao.findByPK(dto.getCourseId());
		 SubjectDTO sdto= sDao.findByPK(dto.getSubjectId());
		 dto.setCourseName(cdto.getName());
		 dto.setSubjectName(sdto.getName());
		pk = (Long) sessionfactory.getCurrentSession().save(dto);
		log.debug("TimeTable Dao Add End");
		return pk;
	}

	public void update(TimeTableDTO dto) {
		log.debug("TimeTable Dao Update Started");
		CourseDTO cdto= cDao.findByPK(dto.getCourseId());
		 SubjectDTO sdto= sDao.findByPK(dto.getSubjectId());
		 dto.setCourseName(cdto.getName());
		 dto.setSubjectName(sdto.getName());
		sessionfactory.getCurrentSession().merge(dto);
		log.debug("TimeTable Dao Update End");
		
	}

	public void delete(long id) {
		log.debug("TimeTable Dao Delete Started");
		TimeTableDTO dto = findByPK(id);
		sessionfactory.getCurrentSession().delete(dto);
		log.debug("TimeTable Dao Delete End");
		
	}

	public TimeTableDTO findTimeTableDuplicacy(Long courseId, String Semester, Date examdate) {
		log.debug("TimeTable Dao FindTimeTableDuplicacy Started");
		TimeTableDTO dto = null;
		List list = sessionfactory.getCurrentSession().createCriteria(TimeTableDTO.class)
				.add(Restrictions.eq("courseId", courseId))
		        .add(Restrictions.eq("semester", Semester))
		.add(Restrictions.eq("examDate", examdate)).list();
		if (list.size() == 1) {
			dto = (TimeTableDTO) list.get(0);
		}
		log.debug("TimeTable Dao FindTimeTableDuplicacy End");
		return dto;
	}

	public TimeTableDTO findTimeTableDuplicacy(Long courseId, Long subjectId, Date examDate) {
		log.debug("TimeTable Dao FindTimeTableDuplicacy Started");
		TimeTableDTO dto = null;
		List list = sessionfactory.getCurrentSession().createCriteria(TimeTableDTO.class)
				.add(Restrictions.eq("courseId", courseId))
		        .add(Restrictions.eq("subjectId", subjectId))
		.add(Restrictions.eq("examDate", examDate)).list();
		if (list.size() == 1) {
			dto = (TimeTableDTO) list.get(0);
		}
		log.debug("TimeTable Dao FindTimeTableDuplicacy End");
		return dto;
	}

	public TimeTableDTO findTimeTableDuplicacy(Long courseId, String Semester, Long subjectId) {
		log.debug("TimeTable Dao FindTimeTableDuplicacy Started");
		TimeTableDTO dto = null;
		List list = sessionfactory.getCurrentSession().createCriteria(TimeTableDTO.class)
				.add(Restrictions.eq("courseId", courseId))
		        .add(Restrictions.eq("semester", Semester))
		.add(Restrictions.eq("subjectId", subjectId)).list();
		if (list.size() == 1) {
			dto = (TimeTableDTO) list.get(0);
		}
		log.debug("TimeTable Dao FindTimeTableDuplicacy End");
		return dto;
	}

	public TimeTableDTO findByPK(long pk) {
		log.debug("TimeTable Dao FindByPK Started");
		TimeTableDTO dto = null;
		dto = (TimeTableDTO) sessionfactory.getCurrentSession().get(TimeTableDTO.class, pk);
		log.debug("TimeTable Dao FindByPK End");
		return dto;
	}

	public List<TimeTableDTO> search(TimeTableDTO dto, int pageNo, int pageSize) {
		log.debug("TimeTableDAOHibImpl search Started");
		Criteria criteria = sessionfactory.getCurrentSession().createCriteria(TimeTableDTO.class);
		
		if(dto!=null)
		{
		if (dto.getId() > 0) {
            criteria.add(Restrictions.eq("id", dto.getId()));
        }if (dto.getCourseId() > 0) {
            criteria.add(Restrictions.eq("courseId", dto.getCourseId()));
        }if (dto.getSubjectId() > 0) {
            criteria.add(Restrictions.eq("subjectId", dto.getSubjectId()));
        }
        if (dto.getTime() != null && dto.getTime().length() > 0) {
            criteria.add(Restrictions.like("examTime", dto.getTime() + "%"));
        }if (dto.getExamDate() != null ) {
            criteria.add(Restrictions.like("examDate", dto.getExamDate() + "%"));
        }
        
		}
        // if page size is greater than zero the apply pagination
        if (pageSize > 0) {
            criteria.setFirstResult(((pageNo - 1) * pageSize));
            criteria.setMaxResults(pageSize);
        }
		List list = criteria.list();
		log.debug("TimeTableDAOHibImpl search End");
		return list;

	}

	public List<TimeTableDTO> search(TimeTableDTO dto) {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

}
