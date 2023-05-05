/**
 * 
 */
package com.safein.backend.service;

import java.util.List;

import com.safein.backend.dto.User;

/**
 * @author Elena, Alejandro, Francisco
 *
 */
public interface IUserService {

	public List<User> listUsers(); /**Get: List all users */
	
	public User saveUser(User user); /**Create: Save an user */

	public User getUserById(Long id); /**Get: Read info about an user */

	public User updateUser(User user);/**Update: an user */

	public void deleteUser(Long id);/** Delete: an user*/
}

