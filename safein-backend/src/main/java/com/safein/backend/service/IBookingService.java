/**
 * 
 */
package com.safein.backend.service;

import java.util.List;

import com.safein.backend.dto.Booking;
import com.safein.backend.dto.Handle;
import com.safein.backend.dto.Room;

/**
 * @author elena-01
 *
 */
public interface IBookingService {
	
	//List All Bookings
	public List<Handle> listAllBookings();
	
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

	// PUT /bookings/{id} user admin
	public Booking updateBooking(Booking booking);

	// DELETE /bookings/{id}
	public void deleteBookingById(Long booking_id);
}
