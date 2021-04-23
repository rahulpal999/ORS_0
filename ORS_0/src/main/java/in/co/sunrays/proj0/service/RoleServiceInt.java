package in.co.sunrays.proj0.service;

import java.util.List;

import in.co.sunrays.proj0.dto.RoleDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;

public interface RoleServiceInt {
	/**
	 * Adds a Role.
	 * 
	 * param dto
	 * return
	 * throws DuplicateRecordException
	 */
	public long add(RoleDTO dto) throws DuplicateRecordException;

	/**
	 * Updates a Role.
	 * 
	 * param dto
	 * throws DuplicateRecordException
	 */
	public void update(RoleDTO dto) throws DuplicateRecordException;

	/**
	 * Deletes a Role
	 * 
	 * param id
	 */
	public void delete(long id);

	/**
	 * Finds a Role by name.
	 * 
	 * param roleName
	 * return
	 */
	public RoleDTO findByName(String roleName);

	/**
	 * Finds a Role by ID
	 * 
	 * param id
	 * return
	 */
	public RoleDTO findById(long id);

	/**
	 * Searches Roles with pagination.
	 * 
	 * param dto
	 * param pageNo
	 * param pageSize
	 * return
	 */
	public List<RoleDTO> search(RoleDTO dto, int pageNo, int pageSize);

	/**
	 * Searches Roles
	 * 
	 * param dto
	 * return
	 */
	public List<RoleDTO> search(RoleDTO dto);
}
