/**
 * 
 */
package com.safein.backend.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.safein.backend.dto.Booking;
import com.safein.backend.dto.Handle;
import com.safein.backend.dto.Room;

/**
 * @author Elena, Alejandro Francisco
 *
 */
public interface IHandleDAO extends JpaRepository<Handle, Long> {

	List<Handle> findByBooking(Booking booking);
	
	Page<Handle> findByBookingSuserEmail(String email, Pageable pageable);

	List<Handle> findByRoom(Room room);
	
	List<Handle> findAll(Sort sort);

}
