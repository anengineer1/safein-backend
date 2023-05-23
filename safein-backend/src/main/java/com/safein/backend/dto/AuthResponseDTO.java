package com.safein.backend.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class AuthResponseDTO {

	@Id
	private long id;
	private String accessToken;
	private String tokenType = "Bearer ";
	private String username;
	private String email;
	private String role;

	public AuthResponseDTO(String accessToken) {
		this.accessToken = accessToken;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the accessToken
	 */
	public String getAccessToken() {
		return accessToken;
	}

	/**
	 * @return the tokenType
	 */
	public String getTokenType() {
		return tokenType;
	}

	/**
	 * @return username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return email adress
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @param accessToken the accessToken to set
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	/**
	 * @param tokenType the tokenType to set
	 */
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	/**
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @param email address
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param user role
	 */
	public void setRole(String role) {
		this.role = role;
	}

}
