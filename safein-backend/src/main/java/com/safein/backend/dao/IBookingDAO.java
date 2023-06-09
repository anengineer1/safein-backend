/**
 * 
 */
package com.safein.backend.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.safein.backend.dto.Booking;
import com.safein.backend.dto.Customers;
import com.safein.backend.dto.Suser;

/**
 * @author Elena, Alejandro Francisco
 *
 */
public interface IBookingDAO extends JpaRepository<Booking, Long> {

	List<Booking> findBySuser(Suser suser);

	List<Booking> findByCustomers(Customers customers);

	//List<Hotel> findByHotel(Hotel hotel);

}
