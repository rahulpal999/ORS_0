package in.co.sunrays.proj0.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.sunrays.proj0.dao.SubjectDAOInt;
import in.co.sunrays.proj0.dto.SubjectDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;

@Service
public class SubjectServiceSpringImpl implements SubjectServiceInt {

	@Autowired
	SubjectDAOInt dao;
	
	private static Logger log = Logger.getLogger(SubjectServiceSpringImpl.class);

    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public long add(SubjectDTO dto) throws DuplicateRecordException {
    	log.debug("SubjectServiceSpringImpl Add Started");
        SubjectDTO dtoExist = dao.findByName(dto.getName());
        if (dtoExist != null) {
            throw new DuplicateRecordException("Subject Name is already exists");
        }
        long pk = dao.add(dto);
        log.debug("SubjectServiceSpringImpl Add End");
        return pk;
	}
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(SubjectDTO dto) throws DuplicateRecordException {
    	log.debug("SubjectServiceSpringImpl update Started");
    	dao.update(dto);
    	log.debug("SubjectServiceSpringImpl update End");
	}
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(long id) {
		log.debug("SubjectServiceSpringImpl delete Started");
   	 dao.delete(id);
   	log.debug("SubjectServiceSpringImpl delete End");
		
	}
    @Transactional( readOnly = false)
	public SubjectDTO findByName(String subjectName) {
		log.debug("SubjectServiceSpringImpl findByName Started");
    	SubjectDTO dto = dao.findByName(subjectName);
    	log.debug("SubjectServiceSpringImpl findByName End");
    	return dto;
	}
    @Transactional( readOnly = false)
	public SubjectDTO findById(long id) {
		log.debug("SubjectServiceSpringImpl findById Started");
    	SubjectDTO dto = dao.findByPK(id);
    	log.debug("SubjectServiceSpringImpl findById End");
    	return dto;
	}
    @Transactional( readOnly = false)
	public List<SubjectDTO> search(SubjectDTO dto, int pageNo, int pageSize) {
		
		return dao.search(dto, pageNo, pageSize);
	}
    @Transactional( readOnly = false)
	public List<SubjectDTO> search(SubjectDTO dto) {
		// TODO Auto-generated method stub
		 return dao.search(dto);
	}

}
