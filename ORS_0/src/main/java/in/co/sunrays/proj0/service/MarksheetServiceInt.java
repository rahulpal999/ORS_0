package in.co.sunrays.proj0.service;

import java.util.List;

import in.co.sunrays.proj0.dto.MarksheetDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;

/**
 * This is MarksheetServiceInt
 *
 */
public interface MarksheetServiceInt {
	/**
	 * Adds a Marksheet.
	 * 
	 * param dto
	 * return
	 * throws DuplicateRecordException
	 */
	public long add(MarksheetDTO dto) throws DuplicateRecordException;

	/**
	 * Updates a Marksheet.
	 * 
	 * param dto
	 * throws DuplicateRecordException
	 */
	public void update(MarksheetDTO dto) throws DuplicateRecordException;

	/**
	 * Deletes a Marksheet
	 * 
	 * param id
	 */
	public void delete(long id);

	/**
	 * Finds a Marksheet by Roll number.
	 * 
	 * param roleNumber
	 * return
	 */
	public MarksheetDTO findByRollNumber(String roleNumber);

	/**
	 * Finds a Marksheet by ID
	 * 
	 * param id
	 * return
	 */
	public MarksheetDTO findById(long id);

	/**
	 * Searches Marksheet with pagination.
	 * 
	 * param dto
	 * param pageNo
	 * param pageSize
	 * return
	 */
	public List<MarksheetDTO> search(MarksheetDTO dto, int pageNo, int pageSize);

	/**
	 * Searches Marksheet
	 * 
	 * param dto
	 * return
	 */
	public List<MarksheetDTO> search(MarksheetDTO dto);
	/**
	 *  Marksheet Merite list
	 * 
	 * param dto
	 * return
	 */
	public List<MarksheetDTO> getMeritList(int pageNo, int pageSize);
}
