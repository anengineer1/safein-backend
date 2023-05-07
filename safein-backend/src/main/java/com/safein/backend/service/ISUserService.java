/**
 * 
 */
package com.safein.backend.service;

import java.util.List;

import com.safein.backend.dto.SUser;

/**
 * @author Elena, Alejandro, Francisco
 *
 */
public interface ISUserService {

	public List<SUser> listUsers(); /**Get: List all users */
	
	public SUser saveUser(SUser user); /**Create: Save an user */

	public SUser getUserById(Long id); /**Get: Read info about an user */

	public SUser updateUser(SUser user);/**Update: an user */

	public void deleteUser(Long id);/** Delete: an user*/
}

