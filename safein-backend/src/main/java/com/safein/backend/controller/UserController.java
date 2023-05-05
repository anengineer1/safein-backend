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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safein.backend.dto.User;
import com.safein.backend.service.UserServiceImpl;

/**
 * @author Elena, Alejandro, Francisco
 *
 */

@RestController
@RequestMapping("/")
public class UserController {

	@Autowired
	UserServiceImpl userServiceImpl;

	/** Get: List all users */
	@GetMapping("/users")
	public List<User> listUsers() {
		return userServiceImpl.listUsers();
	}

	/** Create: Save an user */
	@PostMapping("/users")
	public User saveUser(@RequestBody User user) {

		return userServiceImpl.saveUser(user);
	}

	/** Get: Read info about an user */
	@GetMapping("/users/{id}")
	public User getUserById(Long id) {
		return userServiceImpl.getUserById(id);
	}

	/** Update: an user */
	@PutMapping("/piezas/{id}")
	public User updateUser(@PathVariable(name = "id") Long id, @RequestBody User user) {

		User user_selected = new User();

		user_selected = userServiceImpl.getUserById(id);
		user_selected.setUsername(user.getUsername());
		user_selected.setPassword(user.getPassword());
		user_selected.setNomApels(user.getNomApels());
		user_selected.setEmail(user.getEmail());
		user_selected.setBookings(user.getBookings());

		return userServiceImpl.updateUser(user_selected);
	}

	/** Delete: an user */
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable(name = "id") Long id) {
		userServiceImpl.deleteUser(id);
	}

}
