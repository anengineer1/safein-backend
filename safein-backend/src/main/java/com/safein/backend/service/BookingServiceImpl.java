/**
 * 
 */
package com.safein.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safein.backend.dao.IBookingDAO;
import com.safein.backend.dao.ICustomersDAO;
import com.safein.backend.dao.IHandleDAO;
import com.safein.backend.dao.IHotelsDAO;
import com.safein.backend.dao.IRoomDAO;
import com.safein.backend.dao.IUserDAO;
import com.safein.backend.dto.Booking;
import com.safein.backend.dto.Handle;
import com.safein.backend.dto.Room;

/**
 * @author elena-01
 *
 */
@Service
public class BookingServiceImpl implements IBookingService {

	@Autowired
	IBookingDAO iBookingDAO;
	@Autowired
	IHandleDAO iHandleDAO;
	@Autowired
	IUserDAO iUserDAO;
	@Autowired
	ICustomersDAO iCustomersDAO;
	@Autowired
	IRoomDAO iRoomDAO;
	@Autowired
	IHotelsDAO iHotelsDAO;

	
	
	
	@Override
	public Handle listBookingsByBookingId(Long booking_id) {

		return iHandleDAO.findById(booking_id).get();
	}

	@Override
	public List<Handle> listBookingsByUserId(Long user_id) {
		// TODO Pending User PR
		List<Booking> bk = iBookingDAO.findByUser(iUserDAO.findById(user_id).get());
		List<Handle> hs = new ArrayList<>();

		for (Booking booking : bk) {
			hs.addAll(iHandleDAO.findByBooking(booking));
		}
		return hs;
	}

	@Override
	public List<Handle> listBookingsByCustomerId(Long customer_id) {

		List<Booking> bk = iBookingDAO.findByCustomers(iCustomersDAO.findById(customer_id).get());
		List<Handle> hs = new ArrayList<>();

		for (Booking booking : bk) {
			hs.addAll(iHandleDAO.findByBooking(booking));
		}
		return hs;
	}

	@Override
	public List<Handle> listHandlesByRoomId(Long room_id) {

		return iHandleDAO.findByRoom(iRoomDAO.findById(room_id).get());
	}

	@Override
	public List<Handle> listHandlesByHotelId(Long hotel_id) {
		List<Room> rooms = iRoomDAO.findRoomsByHotelId(hotel_id);
		List<Handle> hs = new ArrayList<>();

		for (Room room : rooms) {
			hs.addAll(iHandleDAO.findByRoom(room));
		}
		return hs;
	}

	@Override
	public Booking saveBooking(Booking booking) {
		
		return iBookingDAO.save(booking);
	}

	@Override
	public Booking updateBooking(Booking booking) {
		
		return iBookingDAO.save(booking);
	}

	@Override
	public void deleteBookingById(Long booking_id) {
		
		iBookingDAO.deleteById(booking_id);
	}

	@Override
	public List<Handle> listAllBookings() {
		
		return iHandleDAO.findAll();
	}

	@Override
	public Booking getBookingById(Long id) {
		// TODO Auto-generated method stub
		return iBookingDAO.findById(id).get();
	}

	@Override
	public Handle saveHandle(Handle handle) {
		// TODO Auto-generated method stub
		return iHandleDAO.save(handle);
	}
	
	

}
