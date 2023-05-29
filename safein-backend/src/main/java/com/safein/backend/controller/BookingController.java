package com.safein.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.safein.backend.dto.Booking;
import com.safein.backend.dto.Handle;
import com.safein.backend.dto.Hotel;
import com.safein.backend.service.BookingServiceImpl;
import com.safein.backend.service.HotelsServiceImpl;

@RestController
public class BookingController {

	@Autowired
	BookingServiceImpl bookingServiceImpl;
	@Autowired
	HotelsServiceImpl hotelsServiceImpl;

	/*
	 * @Autowired HandleServiceImpl handlesServiceImpl;
	 */

	@GetMapping("/booking/handles")
	public List<Handle> listHandles() {
		return bookingServiceImpl.listAllHandles();
	}
	
	@GetMapping("/booking/handles/customer_asc")
	public List<Handle> listHandlesOrderedByCustomerAsc() {
		return bookingServiceImpl.listAllHandlesSortedAscByCustomer();
	}
	
	@GetMapping("/booking/handles/customer_desc")
	public List<Handle> listHandlesOrderedByCustomerDesc() {
		return bookingServiceImpl.listAllHandlesSortedDescByCustomer();
	}

	@GetMapping("/booking/{id}")
	public Booking listBookingXID(@PathVariable(name = "id") Long id) {
		return bookingServiceImpl.getBookingById(id);
	}
	
	@GetMapping("/booking")
	public List<Booking> listBookings() {
		return bookingServiceImpl.listAllBookings();
	}
	
	@GetMapping("/booking/handle/latests")
	public List<Handle> listLatestHandles() {
		return bookingServiceImpl.listLatest5Handles().getContent();
	}
	@GetMapping("/booking/handle/latests/{susers}")
	public List<Handle> listLatestBookingByUserEmail(@PathVariable(name = "susers") String suser_email) {
		return bookingServiceImpl.listLatest5HandlesByUserEmail(suser_email).getContent();
	}
	
	@GetMapping("/booking/handle/{id}")
	public Handle listHandleXID(@PathVariable(name = "id") Long id) {
		return bookingServiceImpl.getHandleById(id);
	}

	@GetMapping("/booking/user/{susers}")
	public List<Handle> listBookingByUser(@PathVariable(name = "susers") Long suser_id) {
		return bookingServiceImpl.listBookingsByUserId(suser_id);
	}

	@GetMapping("/booking/customer/{customer}")
	public List<Handle> listBookingByCustomer(@PathVariable(name = "customer") Long id) {

		return bookingServiceImpl.listBookingsByCustomerId(id);
	}


	@GetMapping("/booking/rooms/{rooms}")
	public List<Handle> listRoomByBookingId(@PathVariable(name = "rooms") Long id) {
		return bookingServiceImpl.listHandlesByRoomId(id);
	}

	@GetMapping("/booking/hotel/{hotel}")
	public List<Handle> listHotelByBookingId(@PathVariable(name = "hotel") Long id) {
		return bookingServiceImpl.listHandlesByHotelId(id);
	}
	
	@GetMapping("booking/hotels_asc")
	public List<Handle> listHandlesOrderedByHotelAsc(){
		return bookingServiceImpl.listAllHandlesSortedAscByHotels();
	}
	
	@GetMapping("booking/hotels_desc")
	public List<Handle> listHandlesOrderedByHotelDesc(){
		return bookingServiceImpl.listAllHandlesSortedDescByHotels();
	}

	@PostMapping("/booking")
	public Booking createBooking(@RequestBody Booking booking) {
		return bookingServiceImpl.saveBooking(booking);
	}
	
	@PostMapping("/handle")
	public Handle createHandle(@RequestBody Handle handle) {
		return bookingServiceImpl.saveHandle(handle);
	}

	
	@PutMapping("/handle/{id}")
	public Handle updateHandle(@PathVariable(name = "id") Long id, @RequestBody Handle handle) {

		Handle booking_selected = bookingServiceImpl.getHandleById(id);

		booking_selected.setDepartureDate(handle.getDepartureDate());
		booking_selected.setArrivalDate(handle.getArrivalDate());
		booking_selected.setRoom(handle.getRoom());
		booking_selected.setBooking(handle.getBooking());
		
		return bookingServiceImpl.saveHandle(booking_selected);
	}
	
	

	@PutMapping("/booking/{id}")
	public Booking updateBooking(@PathVariable(name = "id") Long id, @RequestBody Booking booking) {

		Booking booking_selected = bookingServiceImpl.getBookingById(id);

		booking_selected.setAmount(booking.getAmount());
		booking_selected.setNumPeople(booking.getNumPeople());
		booking_selected.setPayed(booking.isPayed());
		booking_selected.setPendingPay(booking.isPendingPay());
		booking_selected.setSuser(booking.getSuser());
		booking_selected.setCustomers(booking.getCustomers());
		
		return bookingServiceImpl.updateBooking(booking_selected);
	}

	@DeleteMapping("/booking/{id}")
	public String eliminarBooking(@PathVariable(name = "id") Long id) {
		bookingServiceImpl.deleteBookingById(id);
		return "Booking deleted.";
	}
	
	@DeleteMapping("/booking/handle/{id}")
	public String eliminarHandle(@PathVariable(name = "id") Long id) {
		bookingServiceImpl.deleteHandleById(id);
		return "Booking deleted.";
	}
}
