/**
 * 
 */
package com.safein.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safein.backend.dto.SUser;

/**
 * @author Elena, Alejandro, Francisco
 *
 */
public interface ISUserDAO extends JpaRepository<SUser, Long> {

}
