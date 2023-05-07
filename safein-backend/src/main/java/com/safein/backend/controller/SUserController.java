/**
 * 
 */
package com.safein.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safein.backend.dto.SUser;
import com.safein.backend.service.SUserServiceImpl;

/**
 * @author Elena, Alejandro, Francisco
 *
 */

@RestController
public class SUserController {

	@Autowired
	SUserServiceImpl userServiceImpl;

	/** Get: List all users */
	@GetMapping("/susers")
	public List<SUser> listUsers() {
		return userServiceImpl.listUsers();
	}

	/** Create: Save an user */
	@PostMapping("/susers")
	public SUser saveUser(@RequestBody SUser user) {

		return userServiceImpl.saveUser(user);
	}

	/** Get: Read info about an user */
	@GetMapping("/susers/{id}")
	public SUser getUserById(@PathVariable(name = "id") Long id) {
		return userServiceImpl.getUserById(id);
	}

	/** Update: an user */
	@PutMapping("/susers/{id}")
	public SUser updateUser(@PathVariable(name = "id") Long id, @RequestBody SUser user) {

		SUser user_selected = new SUser();

		user_selected = userServiceImpl.getUserById(id);
		user_selected.setUsername(user.getUsername());
		user_selected.setPassword(user.getPassword());
		user_selected.setNomApels(user.getNomApels());
		user_selected.setEmail(user.getEmail());
		user_selected.setBookings(user.getBookings());

		return userServiceImpl.updateUser(user_selected);
	}

	/** Delete: an user */
	@DeleteMapping("/susers/{id}")
	public void deleteUser(@PathVariable(name = "id") Long id) {
		userServiceImpl.deleteUser(id);
	}

}
