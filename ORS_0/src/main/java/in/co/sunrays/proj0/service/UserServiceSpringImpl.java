package in.co.sunrays.proj0.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.sunrays.proj0.dao.UserDAOInt;
import in.co.sunrays.proj0.dto.RoleDTO;
import in.co.sunrays.proj0.dto.UserDTO;
import in.co.sunrays.proj0.exception.ApplicationException;
import in.co.sunrays.proj0.exception.DuplicateRecordException;
import in.co.sunrays.proj0.util.EmailBuilder;

@Service(value = "userService")
public class UserServiceSpringImpl implements UserServiceInt{

    @Autowired
    private UserDAOInt dao = null;
    @Autowired
    private RoleServiceInt roleService;
    @Autowired
    private JavaMailSenderImpl mailSender;

    private static Logger log = Logger.getLogger(UserServiceSpringImpl.class);
    
    public void setMailSender(JavaMailSenderImpl mailSender) {
        this.mailSender = mailSender;
    }

    public void setDao(UserDAOInt dao) {
        this.dao = dao;
    }

@Transactional(propagation=Propagation.REQUIRES_NEW,readOnly=false)
public long add(UserDTO dto) throws DuplicateRecordException {
	log.debug("UserServiceSpringImpl Add Started");
	
	UserDTO dtoExist = dao.findByLogin(dto.getEmailId());
	
	if (dtoExist != null) 
	{
		throw new DuplicateRecordException("Login Id is already exist");
	}
	
	long pk = dao.add(dto);
	
	log.debug("UserServiceSpringImpl  Add End");
	return pk;
}

@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public long registerUser(UserDTO dto) throws DuplicateRecordException, ApplicationException {
	log.debug("UserServiceSpringImpl registerUser Started");
	RoleDTO rdto=roleService.findById(dto.getRoleId());
    dto.setRoleName(rdto.getName());
	long id = add(dto);

    HashMap<String, String> map = new HashMap<String, String>();
    map.put("login", dto.getEmailId());
    map.put("password", dto.getPassword());

    String message = EmailBuilder.getUserRegistrationMessage(map);

    MimeMessage msg = mailSender.createMimeMessage();

    try {
        MimeMessageHelper helper = new MimeMessageHelper(msg);
        helper.setTo(dto.getEmailId());
        helper.setSubject("Registration is successful for ORS Project SUNRAYS Technologies.");
        // use the true flag to indicate the text included is HTML
        helper.setText(message, true);
        mailSender.send(msg);
    } catch (MessagingException e) {
        System.out.println("Mail Sending Failed");
        e.printStackTrace();
    }
    log.debug("UserServiceSpringImpl  registerUser End");
    return id;
}

@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public void update(UserDTO dto) throws DuplicateRecordException {
	log.debug("UserServiceSpringImpl update Started");
    dao.update(dto);
    log.debug("UserServiceSpringImpl  update End");
}

@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public void delete(long id) {
	log.debug("UserServiceSpringImpl delete Started");
    dao.delete(id);
    log.debug("UserServiceSpringImpl  delete End");
}

@Transactional(readOnly = true)
public UserDTO findByLogin(String login) {
	log.debug("UserServiceSpringImpl findByLogin Started");
       UserDTO dto = dao.findByLogin(login);
    log.debug("UserServiceSpringImpl  findByLogin End");
       return dto;
}

@Transactional(readOnly = true)
public UserDTO findByPK(long pk) {
	log.debug("UserServiceSpringImpl findByPK Started");
       UserDTO dto = dao.findByPK(pk);
    log.debug("UserServiceSpringImpl  findByPK End");
       return dto;
}

@Transactional(readOnly = true)
public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize) {
	log.debug("UserServiceSpringImpl findByPK Started");
    log.debug("UserServiceSpringImpl  findByPK End");
    return dao.search(dto, pageNo, pageSize);
}
@Transactional(readOnly = true)
public List search(UserDTO dto) {
	return dao.search(dto);
}

@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public boolean changePassword(Long id, String oldPassword, String newPassword) throws DuplicateRecordException {
	 UserDTO dto = findByPK(id);
        if (oldPassword.equals(dto.getPassword())) {
            dto.setPassword(newPassword);
            dao.update(dto);
            return true;
        } else {
            return false;
        }
}

@Transactional(readOnly = true)
public UserDTO authenticate(UserDTO dto) {
	UserDTO dtoExist = dao.findByLogin(dto.getEmailId());
    if (dtoExist != null && dtoExist.getPassword().equals(dto.getPassword())) {
        return dtoExist;
    }
    return null;
}

@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
public boolean resetPassword(String login) throws ApplicationException {
	log.debug("UserServiceSpringImpl resetPassword Started");
    
	boolean flag = false;
    UserDTO dtoExist = null;
    dtoExist = dao.findByLogin(login);
    if (dtoExist != null) {
        String newPassword = String.valueOf(new Date().getTime()).substring(0, 4);
        dtoExist.setPassword(newPassword);
        dao.update(dtoExist);

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("login", dtoExist.getEmailId());
        map.put("password", dtoExist.getPassword());
        map.put("firstName", dtoExist.getFirstName());
        map.put("lastName", dtoExist.getLastName());
        String message = EmailBuilder.getForgetPasswordMessage(map);

        MimeMessage msg = mailSender.createMimeMessage();

        // use the true flag to indicate you need a multipart message
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(msg, true);
            helper.setTo(dtoExist.getEmailId());
            helper.setSubject("Password has been reset.");
            // use the true flag to indicate the text included is HTML
            helper.setText(message, true);
        } catch (MessagingException e) {
            System.out.println("Mail Sending Failed");
            e.printStackTrace();
        }
        mailSender.send(msg);

        flag = true;
    } else {
    }
    log.debug("UserServiceSpringImpl  resetPassword End");
    return flag;

}

@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
public boolean forgetPassword(String login) throws ApplicationException {
	log.debug("UserServiceSpringImpl forgetPassword Started");
	UserDTO dtoExist = dao.findByLogin(login);

    if (dtoExist != null) {

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("firstName", dtoExist.getFirstName());
        map.put("lastName", dtoExist.getLastName());
        map.put("login", dtoExist.getEmailId());
        map.put("password", dtoExist.getPassword());

        String message = EmailBuilder.getForgetPasswordMessage(map);

        MimeMessage msg = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(msg);
            helper.setTo(login);
            helper.setSubject("SunilOS ORS Password reset");
            // use the true flag to indicate the text included is HTML
            helper.setText(message, true);
            mailSender.send(msg);
        } catch (MessagingException e) {
            e.printStackTrace();
            log.error(e);
            return false;
        }
    } else {
        return false;
    }
    log.debug("UserServiceSpringImpl forgetPassword End");
    return true;

}

 @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public RoleDTO getRole(UserDTO dto) {
        return roleService.findById(dto.getRoleId());
    }


}
