/**
 * 
 */
package com.safein.backend.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.safein.backend.dto.Booking;
import com.safein.backend.dto.Handle;
import com.safein.backend.dto.Hotel;
import com.safein.backend.dto.Room;

/**
 * @author elena-01
 *
 */
public interface IBookingService {
	
	//List All Handles
	public List<Handle> listAllHandles();
	
	//List All Bookings
	public List<Booking> listAllBookings();
	

	// List all Handle sorted by Customer by ascending order
	public List<Handle> listAllHandlesSortedAscByCustomer();
	
	// List all Handle sorted by Customer by descending order
	public List<Handle> listAllHandlesSortedDescByCustomer();
	
	//Get Booking By Booking_id
	public Booking getBookingById(Long id);
	
	//Create Booking
	public Booking saveBooking(Booking booking);
	
	//Create Handle
	public Handle saveHandle(Handle handle);

	// GET /bookings/{id} rol admin user (Llamada desde handles) GET
	public Handle listBookingsByBookingId(Long booking_id);

	// /bookings/user/{usersid} user admin (Llamada desde handles) GET
	public List<Handle> listBookingsByUserId(Long user_id);// De bookings

	// bookings/client/{clientid} user admin (Llamada desde handles) GET
	public List<Handle> listBookingsByCustomerId(Long customer_id);

	// bookings/rooms user admin (Llamada desde handles) GET /bookings/rooms/{id}
	public List<Handle> listHandlesByRoomId(Long booking_id);

	// (Handles) GET /bookings/hotel/{id} (Handles) GET /bookings rol user admin
	public List<Handle> listHandlesByHotelId(Long hotel_id);
	
	public Handle getHandleById(Long id);

	// PUT /bookings/{id} user admin
	public Booking updateBooking(Booking booking);

	// DELETE /bookings/{id}
	public void deleteBookingById(Long booking_id);
	
	// DELETE /handles/{id}
	public void deleteHandleById(Long handle_id);

	
	//List All handles sort by hotels ASC and DESC
	public List<Handle> listAllHandlesSortedAscByHotels();

	public List<Handle> listAllHandlesSortedDescByHotels();
	
	// List 5 latests handles
	public Page<Handle> listLatest5Handles();
	
	// List latest 5 handles filtered by user 
	public Page<Handle> listLatest5HandlesByUserEmail(String email);
}
