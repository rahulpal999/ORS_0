package in.co.sunrays.proj0.service;

import java.util.List;

import in.co.sunrays.proj0.dto.CollegeDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;

public interface CollegeServiceInt {
	/**
	 * Adds a College.
	 * 
	 * param dto
	 * return
	 * throws DuplicateRecordException
	 */
	public long add(CollegeDTO dto) throws DuplicateRecordException;

	/**
	 * Updates a College.
	 * 
	 * param dto
	 * throws DuplicateRecordException
	 */
	public void update(CollegeDTO dto) throws DuplicateRecordException;

	/**
	 * Deletes a College
	 * 
	 * param id
	 */
	public void delete(long id);

	/**
	 * Finds a College by name.
	 * 
	 * param name
	 * return
	 */
	public CollegeDTO findByName(String name);

	/**
	 * Finds a College by ID
	 * 
	 * param id
	 * return
	 */
	public CollegeDTO findById(long id);

	/**
	 * Searches College with pagination.
	 * 
	 * param dto
	 * param pageNo
	 * param pageSize
	 * return
	 */
	public List search(CollegeDTO dto, int pageNo, int pageSize);

	/**
	 * Searches College
	 * 
	 * param dto
	 * return
	 */
	public List search(CollegeDTO dto);

}
