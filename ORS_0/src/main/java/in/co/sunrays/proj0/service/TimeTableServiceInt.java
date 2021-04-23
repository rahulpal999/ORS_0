package in.co.sunrays.proj0.service;

import java.util.Date;
import java.util.List;



import in.co.sunrays.proj0.dto.TimeTableDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;

public interface TimeTableServiceInt {
	/**
	 * Adds a TimeTable.
	 * 
	 * param dto
	 * return
	 * throws DuplicateRecordException
	 */
	public long add(TimeTableDTO dto) throws DuplicateRecordException;

	/**
	 * Updates a TimeTable.
	 * 
	 * param dto
	 * throws DuplicateRecordException
	 */
	public void update(TimeTableDTO dto) throws DuplicateRecordException;

	/**
	 * Deletes a TimeTable
	 * 
	 * param id
	 */
	public void delete(long id);

	
	/**
	 * Finds a TimeTable by ID
	 * 
	 * param id
	 * return
	 */
	public TimeTableDTO findByPk(long id);
	

	/**
	 * Searches TimeTables with pagination.
	 * 
	 * param dto
	 * param pageNo
	 * param pageSize
	 * return
	 */
	public List<TimeTableDTO> search(TimeTableDTO dto, int pageNo, int pageSize);

	/**
	 * Searches TimeTables
	 * 
	 * param dto
	 * return
	 */
	public List<TimeTableDTO> search(TimeTableDTO dto);
}
