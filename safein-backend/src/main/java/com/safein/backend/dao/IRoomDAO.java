/**
 * 
 */
package com.safein.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safein.backend.dto.Room;


/**
 * @author Elena, Alejandro, Francisco
 *
 */
public interface IRoomDAO  extends JpaRepository<Room, Long>{

}
