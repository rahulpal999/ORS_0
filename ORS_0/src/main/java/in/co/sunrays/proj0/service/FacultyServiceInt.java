package in.co.sunrays.proj0.service;

import java.util.List;

import in.co.sunrays.proj0.dto.FacultyDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;

public interface FacultyServiceInt {

	/**
     * Adds a user
     * 
     * param dto
     * throws DuplicateRecordException
     */
    public long add(FacultyDTO dto)throws DuplicateRecordException;

    /**
     * Updates a User
     * 
     * param dto
     * throws DuplicateRecordException
     */
    public void update(FacultyDTO dto)throws DuplicateRecordException;

    /**
     * Deletes a user
     * 
     * param dto
     */
    public void delete(long id);

    /**
     * Finds user by Login
     * 
     * param login
     *            : get parameter
     * return dto
     */
    public FacultyDTO findByEmail(String login);

    /**
     * Finds user by PK
     * 
     * param pk
     *            : get parameter
     * return dto
     */
    public FacultyDTO findByPK(long pk);

    /**
     * Searches Users with pagination
     * 
     * return list : List of Users
     * param dto
     *            : Search Parameters
     * param pageNo
     *            : Current Page No.
     * param pageSize
     *            : Size of Page
     */
    public List<FacultyDTO> search(FacultyDTO dto, int pageNo, int pageSize);

    /**
     * Searches Users
     * 
     * return list : List of Users
     * param dto
     *            : Search Parameters
     */
    public List<FacultyDTO> search(FacultyDTO dto);
}
