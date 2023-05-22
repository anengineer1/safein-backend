/**
 * 
 */
package com.safein.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safein.backend.dto.Suser;

/**
 * @author Elena, Alejandro, Francisco
 *
 */
public interface ISuserDAO extends JpaRepository<Suser, Long> {
	Suser findByUsername(Object username);
}
