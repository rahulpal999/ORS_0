package in.co.sunrays.proj0.service;

import java.util.List;

import in.co.sunrays.proj0.dto.RoleDTO;
import in.co.sunrays.proj0.dto.UserDTO;
import in.co.sunrays.proj0.exception.ApplicationException;
import in.co.sunrays.proj0.exception.DuplicateRecordException;

public interface UserServiceInt {

	/**
     * Adds a user
     * 
     * param dto
     * throws DuplicateRecordException
     */
    public long add(UserDTO dto)throws DuplicateRecordException;

    /**
     * Registers a user
     * 
     * param dto
     * throws ApplicationException
     * throws DuplicateRecordException
     */
    public long registerUser(UserDTO dto) throws DuplicateRecordException,ApplicationException;

    /**
     * Updates a User
     * 
     * param dto
     * throws DuplicateRecordException
     */
    public void update(UserDTO dto)throws DuplicateRecordException;

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
    public UserDTO findByLogin(String login);

    /**
     * Finds user by PK
     * 
     * param pk
     *            : get parameter
     * return dto
     */
    public UserDTO findByPK(long pk);

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
    public List search(UserDTO dto, int pageNo, int pageSize);

    /**
     * Searches Users
     * 
     * return list : List of Users
     * param dto
     *            : Search Parameters
     */
    public List search(UserDTO dto);

    /**
     * Change Password By pk
     * 
     * param pk
     *            ,oldPassword,newPassword : get parameter
     * return dto
     */
    public boolean changePassword(Long id, String oldPassword,
            String newPassword) throws DuplicateRecordException;

    /**
     * User Authentication
     * 
     * return dto : Contains User's information
     * param dto
     */
    public UserDTO authenticate(UserDTO dto);


    /**
     * Reset Password of User with auto generated Password
     * 
     * return boolean : true if success otherwise false
     * param login
     *            : User Login
     * throws ApplicationException
     */
    public boolean resetPassword(String login) throws ApplicationException;

    /**
     * Send the password of User to his Email
     * 
     * return boolean : true if success otherwise false
     * param login
     *            : User Login
     * throws ApplicationException
     */
    public boolean forgetPassword(String login) throws ApplicationException;

    public RoleDTO getRole(UserDTO dto);

	
}
