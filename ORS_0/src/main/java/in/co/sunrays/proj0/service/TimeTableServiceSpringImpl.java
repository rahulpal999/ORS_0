package in.co.sunrays.proj0.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.sunrays.proj0.dao.TimeTableDAOInt;
import in.co.sunrays.proj0.dto.TimeTableDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;
@Service
public class TimeTableServiceSpringImpl implements TimeTableServiceInt{
    @Autowired
	TimeTableDAOInt dao;
private static Logger log = Logger.getLogger(TimeTableServiceSpringImpl.class);
	
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public long add(TimeTableDTO dto) throws DuplicateRecordException {

    	log.debug("CourseServiceSpringImpl Add Started");
    	TimeTableDTO dtoExist1 = dao.findTimeTableDuplicacy(dto.getCourseId(), dto.getSubjectId(), dto.getExamDate());
    	TimeTableDTO dtoExist2 = dao.findTimeTableDuplicacy(dto.getCourseId(), dto.getSemester(), dto.getExamDate());
    	TimeTableDTO dtoExist3 = dao.findTimeTableDuplicacy(dto.getCourseId(), dto.getSemester(), dto.getSubjectId());
    	if (dtoExist1 != null||dtoExist2!=null||dtoExist3!=null) {
            throw new DuplicateRecordException("TimeTable already exists");
        }
        long pk = dao.add(dto);
        log.debug("CourseServiceSpringImpl Add End");
        return pk;
	}
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(TimeTableDTO dto) throws DuplicateRecordException {
		log.debug("CourseServiceSpringImpl update Started");
		TimeTableDTO dtoExist1 = dao.findTimeTableDuplicacy(dto.getCourseId(), dto.getSubjectId(), dto.getExamDate());
    	TimeTableDTO dtoExist2 = dao.findTimeTableDuplicacy(dto.getCourseId(), dto.getSemester(), dto.getExamDate());
    	TimeTableDTO dtoExist3 = dao.findTimeTableDuplicacy(dto.getCourseId(), dto.getSemester(), dto.getSubjectId());
    	
    	if (dtoExist1 != null&&dtoExist1.getId()!=dto.getId()) {
            throw new DuplicateRecordException("TimeTable already exists");
        }if (dtoExist2!=null&&dtoExist2.getId()!=dto.getId()) {
            throw new DuplicateRecordException("TimeTable already exists");
        }if (dtoExist3!=null&&dtoExist3.getId()!=dto.getId()) {
            throw new DuplicateRecordException("TimeTable already exists");
        }
		
		dao.update(dto);
		
    	log.debug("CourseServiceSpringImpl update End");
	}
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public void delete(long id) {
		log.debug("CourseServiceSpringImpl delete Started");
	   	 dao.delete(id);
	   	log.debug("CourseServiceSpringImpl delete End");
		
	}
	@Transactional( readOnly = false)
	public TimeTableDTO findByPk(long id) {
		log.debug("CourseServiceSpringImpl findById Started");
		TimeTableDTO dto = dao.findByPK(id);
    	log.debug("CourseServiceSpringImpl findById End");
    	return dto;
	}

	
	@Transactional( readOnly = false)
	public List<TimeTableDTO> search(TimeTableDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return dao.search(dto, pageNo, pageSize);
	}
	@Transactional( readOnly = false)
	public List<TimeTableDTO> search(TimeTableDTO dto) {
		// TODO Auto-generated method stub
		return dao.search(dto);
	}

}
