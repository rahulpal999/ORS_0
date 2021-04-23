package in.co.sunrays.proj0.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.sunrays.proj0.dao.CourseDAOInt;
import in.co.sunrays.proj0.dto.CourseDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;
@Service
public class CourseServiceSpringImpl implements CourseServiceInt {
	
	@Autowired
	CourseDAOInt dao;
	
	private static Logger log = Logger.getLogger(CourseServiceSpringImpl.class);
	
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public long add(CourseDTO dto) throws DuplicateRecordException {

    	log.debug("CourseServiceSpringImpl Add Started");
    	CourseDTO dtoExist = dao.findByName(dto.getName());
        if (dtoExist != null) {
            throw new DuplicateRecordException("Course Name already exists");
        }
        long pk = dao.add(dto);
        log.debug("CourseServiceSpringImpl Add End");
        return pk;
	}
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(CourseDTO dto) throws DuplicateRecordException {
		log.debug("CourseServiceSpringImpl update Started");
    	dao.update(dto);
    	log.debug("CourseServiceSpringImpl update End");
	}
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public void delete(long id) {
		log.debug("CourseServiceSpringImpl delete Started");
   	 dao.delete(id);
   	log.debug("CourseServiceSpringImpl delete End");
		
	}
	@Transactional(readOnly = false)
	public CourseDTO findByName(String courseName) {
		log.debug("CourseServiceSpringImpl findByName Started");
		CourseDTO dto = dao.findByName(courseName);
    	log.debug("CourseServiceSpringImpl findByName End");
    	return dto;
	}
	@Transactional(readOnly = false)
	public CourseDTO findById(long id) {
		log.debug("CourseServiceSpringImpl findById Started");
		CourseDTO dto = dao.findByPK(id);
    	log.debug("CourseServiceSpringImpl findById End");
    	return dto;
	}
	@Transactional( readOnly = false)
	public List<CourseDTO> search(CourseDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);
	}
	@Transactional(readOnly = false)
	public List<CourseDTO> search(CourseDTO dto) {
		return dao.search(dto);
	}

}
