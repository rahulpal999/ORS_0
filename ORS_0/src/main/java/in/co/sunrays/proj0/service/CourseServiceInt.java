package in.co.sunrays.proj0.service;

import java.util.List;

import in.co.sunrays.proj0.dto.CourseDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;

/**
 * The Interface of CourseServiceInt
 *
 */
public interface CourseServiceInt {
	/**
	 * Adds a Course.
	 * 
	 * param dto
	 * return
	 * throws DuplicateRecordException
	 */
	public long add(CourseDTO dto) throws DuplicateRecordException;

	/**
	 * Updates a Course.
	 * 
	 * param dto
	 * throws DuplicateRecordException
	 */
	public void update(CourseDTO dto) throws DuplicateRecordException;

	/**
	 * Deletes a CourseDTO
	 * 
	 * param id
	 */
	public void delete(long id);

	/**
	 * Finds a Course by name.
	 * 
	 * param roleName
	 * return
	 */
	public CourseDTO findByName(String courseName);

	/**
	 * Finds a Course by ID
	 * 
	 * param id
	 * return
	 */
	public CourseDTO findById(long id);

	/**
	 * Searches Course with pagination.
	 * 
	 * param dto
	 * param pageNo
	 * param pageSize
	 * return
	 */
	public List<CourseDTO> search(CourseDTO dto, int pageNo, int pageSize);

	/**
	 * Searches Course
	 * 
	 * param dto
	 * return
	 */
	public List<CourseDTO> search(CourseDTO dto);
}
