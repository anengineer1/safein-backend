package com.safein.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.safein.backend.dto.Booking;
import com.safein.backend.dto.Room;

public class BookingController {

	@Autowired
	BookingServiceImpl bookingServiceImpl;

	@Autowired
	HandlesServiceImpl handlesServiceImpl;
	

	@GetMapping("/booking")
	public List<Booking> listarBookings() {
		return handlesServiceImpl.listBoking();
	}

	@GetMapping("/booking/{id}")
	public Booking listBookingXID(@PathVariable(name = "id") int id) {
		return handlesServiceImpl.listBookingById(id);
	}

	@GetMapping("/booking/user/{userid}")
	public List<Booking> listBookingByUser(@PathVariable(name = "users") String users) {
		return handlesServiceImpl.listBookingByUsers(users);
	}

	@GetMapping("/booking/customer/{customerid}")
	public List<Booking> listBookingByCustomer(@PathVariable(name = "customer") int id) {

		return handlesServiceImpl.listBookingByCustomerId(id);
	}
/*
	@GetMapping("/booking/rooms")
	public List<Booking> listBookingByRooms(@PathVariable(name = "rooms") String rooms) {

		return handlesServiceImpl.listRoomsByBooking(rooms);
	}*/

	@GetMapping("/booking/rooms/{id}")
	public List<Room> listRoomByBookingId(@PathVariable(name = "rooms") int id) {
		return handlesServiceImpl.listRoomByBookings(id);
	}
	@GetMapping("/booking/hotel/{id}")
	public List<Room> listHotelByBookingId(@PathVariable(name = "hotel") int id) {
		return handlesServiceImpl.listHotelByBookings(id);
	}
@PostMapping("/booking")
public Booking createBooking (@RequestBody Booking booking) {
	return bookingServiceImpl.createBooking(booking);
}
@PutMapping("/booking/{id}")
public Booking updateBooking (@PathVariable (name = "id")int id, @RequestBody Booking booking) {

Booking booking_actualizado = new Booking();

Booking booking_seleccionado = bookingServiceImpl.bookingById(id);

booking_seleccionado.setDoc_identifier(booking.getDoc_identifier());
booking_seleccionado.setEmail(booking.getEmail());
booking_seleccionado.setName(booking.getName());
booking_seleccionado.setPhonenumber(booking.getPhonenumber());
booking_seleccionado.setNum_identifier(booking.getNum_identifier());
booking_seleccionado.setPress_media(booking.getPress_media());

booking_seleccionado = bookingServiceImpl.updateBooking(booking_seleccionado);

System.out.println("El empleado actualizado es: " + costumers_actualizado);

return booking_actualizado;
}

@DeleteMapping("/booking/{id}")
public String eliminarBooking(@PathVariable(name="id")int id) {
	bookingServiceImpl.deleteBookingById(id);
	return "Booking deleted.";
}
}

