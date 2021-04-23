package in.co.sunrays.proj0.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.sunrays.proj0.dao.MarksheetDAOInt;
import in.co.sunrays.proj0.dto.MarksheetDTO;
import in.co.sunrays.proj0.dto.RoleDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;
@Service
public class MarksheetServiceSpringImpl implements MarksheetServiceInt{

	@Autowired
	MarksheetDAOInt dao;
	
	private static Logger log = Logger.getLogger(MarksheetServiceSpringImpl.class);
	
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public long add(MarksheetDTO dto) throws DuplicateRecordException {
		log.debug("MarksheetServiceSpringImpl Add Started");
		MarksheetDTO dtoExist = dao.findByRollNumber(dto.getRollNo());
        if (dtoExist != null) {
            throw new DuplicateRecordException("Role Number already exists");
        }
        long pk = dao.add(dto);
        log.debug("MarksheetServiceSpringImpl Add End");
        return pk;
	}
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(MarksheetDTO dto) throws DuplicateRecordException {
		log.debug("MarksheetServiceSpringImpl update Started");
    	dao.update(dto);
    	log.debug("MarksheetServiceSpringImpl update End");
		
	}
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(long id) {
		log.debug("MarksheetServiceSpringImpl delete Start");
   	 dao.delete(id);
   	log.debug("MarksheetServiceSpringImpl delete End");
		
	}
	@Transactional(readOnly = false)
	public MarksheetDTO findByRollNumber(String roleNumber) {
		log.debug("MarksheetServiceSpringImpl findByRollNumber Started");
		MarksheetDTO dto = dao.findByRollNumber(roleNumber);
    	log.debug("MarksheetServiceSpringImpl findByRollNumber End");
    	return dto;
	}
	@Transactional(readOnly = false)
	public MarksheetDTO findById(long id) {
		log.debug("MarksheetServiceSpringImpl findById Started");
		MarksheetDTO dto = dao.findByPK(id);
    	log.debug("MarksheetServiceSpringImpl findById End");
    	return dto;
	}
	@Transactional(readOnly = false)
	public List<MarksheetDTO> search(MarksheetDTO dto, int pageNo, int pageSize) {
		
		return dao.search(dto, pageNo, pageSize);
	}
	@Transactional(readOnly = false)
	public List<MarksheetDTO> search(MarksheetDTO dto) {
		
		return dao.search(dto);
	}
	@Transactional(readOnly = false)
	public List<MarksheetDTO> getMeritList( int pageNo, int pageSize) {
		
		return dao.search(new MarksheetDTO(), pageNo, pageSize);
	}

}
