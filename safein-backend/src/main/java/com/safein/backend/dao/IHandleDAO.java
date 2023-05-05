/**
 * 
 */
package com.safein.backend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safein.backend.dto.Booking;
import com.safein.backend.dto.Handle;

/**
 * @author Elena, Alejandro Francisco
 *
 */
public interface IHandleDAO extends JpaRepository<Handle, Long> {

	List<Handle> findByBooking(Booking booking);

}
