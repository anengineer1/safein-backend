/**
 * 
 */
package com.safein.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safein.backend.dao.IUserDAO;
import com.safein.backend.dto.User;

/**
 * @author Elena, Alejandro, Francisco
 *
 */

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	IUserDAO iUserDAO;

	 /**Get: List all users */
	@Override
	public List<User> listUsers() {

		return iUserDAO.findAll();
	}

	 /**Create: Save an user */
	@Override
	public User saveUser(User user) {

		return iUserDAO.save(user);
	}

	/**Get: Read info about an user */
	@Override
	public User getUserById(Long id) {
		
		return iUserDAO.findById(id).get();
	}

	/**Update: an user */
	@Override
	public User updateUser(User user) {

		return iUserDAO.save(user);
	}

	/** Delete: an user*/
	@Override
	public void deleteUser(Long id) {
		iUserDAO.deleteById(id);
	}
}
