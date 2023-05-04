/**
 * 
 */
package com.safein.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safein.backend.dto.User;

/**
 * @author Elena, Alejandro, Francisco
 *
 */
public interface IUserDAO extends JpaRepository<User, Long> {

}
