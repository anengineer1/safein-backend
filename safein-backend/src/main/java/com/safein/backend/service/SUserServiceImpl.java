/**
 * 
 */
package com.safein.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safein.backend.dao.ISuserDAO;
import com.safein.backend.dto.Suser;

/**
 * @author Elena, Alejandro, Francisco
 *
 */

@Service
public class SUserServiceImpl implements ISUserService {
	@Autowired
	ISuserDAO iUserDAO;

	 /**Get: List all users */
	@Override
	public List<Suser> listUsers() {

		return iUserDAO.findAll();
	}

	 /**Create: Save an user */
	@Override
	public Suser saveUser(Suser user) {

		return iUserDAO.save(user);
	}

	/**Get: Read info about an user */
	@Override
	public Suser getUserById(Long id) {
		
		return iUserDAO.findById(id).get();
	}

	/**Update: an user */
	@Override
	public Suser updateUser(Suser user) {

		return iUserDAO.save(user);
	}

	/** Delete: an user*/
	@Override
	public void deleteUser(Long id) {
		iUserDAO.deleteById(id);
	}

	/**Get: An user by username
	 * @param username
	 * 
	 * */
	@Override
	public Suser getUserByUsername(String username) {
		
		return iUserDAO.findByUsername(username);
	}
}
