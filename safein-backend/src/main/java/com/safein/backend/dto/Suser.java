/**
 * 
 */
package com.safein.backend.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * @author Elena, Alejandro, Francisco
 *
 */

@Entity
@Table(name = "susers")
public class Suser {

	// ----------------- Atributes -----------------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "email")
	private String email;

	@Column(name = "nomapels")
	private String nomApels;

	@Column(name = "role")
	private String role;

	@OneToMany(mappedBy = "suser", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Booking> bookings;

	// ----------------- Constructors -----------------
	/**
	 * Default Constructor
	 */
	public Suser() {

	}

	/**
	 * @param id
	 * @param username
	 * @param password
	 * @param email
	 * @param nomApels
	 * @param role
	 * @param bookings
	 */
	public Suser(Long id, String username, String password, String email, String nomApels, String role,
			List<Booking> bookings) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.nomApels = nomApels;
		this.role = role;
		this.bookings = bookings;
	}

	// ----------------- Getters + Setters -----------------
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the nomApels
	 */
	public String getNomApels() {
		return nomApels;
	}

	/**
	 * @param nomApels the nomApels to set
	 */
	public void setNomApels(String nomApels) {
		this.nomApels = nomApels;
	}

	/**
	 * @return the bookings
	 */
	@JsonIgnore
	public List<Booking> getBookings() {
		return bookings;
	}

	/**
	 * @param bookings the bookings to set
	 */
	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	// ----------------- Methods -----------------

	@Override
	public String toString() {
		return "Suser [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", nomApels=" + nomApels + ", role=" + role + ", bookings=" + bookings + "]";
	}

}
