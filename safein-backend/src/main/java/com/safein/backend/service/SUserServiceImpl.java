/**
 * 
 */
package com.safein.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safein.backend.dao.ISUserDAO;
import com.safein.backend.dto.SUser;

/**
 * @author Elena, Alejandro, Francisco
 *
 */

@Service
public class SUserServiceImpl implements ISUserService {
	@Autowired
	ISUserDAO iUserDAO;

	 /**Get: List all users */
	@Override
	public List<SUser> listUsers() {

		return iUserDAO.findAll();
	}

	 /**Create: Save an user */
	@Override
	public SUser saveUser(SUser user) {

		return iUserDAO.save(user);
	}

	/**Get: Read info about an user */
	@Override
	public SUser getUserById(Long id) {
		
		return iUserDAO.findById(id).get();
	}

	/**Update: an user */
	@Override
	public SUser updateUser(SUser user) {

		return iUserDAO.save(user);
	}

	/** Delete: an user*/
	@Override
	public void deleteUser(Long id) {
		iUserDAO.deleteById(id);
	}
}
