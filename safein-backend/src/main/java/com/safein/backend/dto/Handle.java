/**
 * 
 */
package com.safein.backend.dto;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * @author Elena, Alejandro, Francisco
 *
 */
@Entity
@Table(name = "handles")
public class Handle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "arrival_date")
	private LocalDateTime arrivalDate;

	@Column(name = "departure_date")
	private LocalDateTime departureDate;

	@ManyToOne
	@JoinColumn(name = "booking_id")
	private Booking booking;

	@ManyToOne
	@JoinColumn(name = "room_id")
	private Room room;

	/**
	 * Default constructor
	 */
	public Handle() {
	}

	/**
	 * Constructor with parameters
	 * 
	 * @param id
	 * @param arrivalDate
	 * @param departureDate
	 * @param booking
	 * @param room
	 */
	public Handle(long id, LocalDateTime arrivalDate, LocalDateTime departureDate, Booking booking, Room room) {
		this.id = id;
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
		this.booking = booking;
		this.room = room;
	}

	/**
	 * Sets the internal id
	 * 
	 * @param id (long)
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Sets the arrival date
	 * 
	 * @param arrivalDate (LocalDateTime)
	 */
	public void setArrivalDate(LocalDateTime arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	/**
	 * Sets the departure date
	 * 
	 * @param departureDate (LocalDateTime)
	 */

	public void setDepartureDate(LocalDateTime departureDate) {
		this.departureDate = departureDate;
	}

	/**
	 * Sets the booking
	 * 
	 * @param booking (Booking)
	 */
	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	/**
	 * Sets the room
	 * 
	 * @param room (Room)
	 */
	public void setRoom(Room room) {
		this.room = room;
	}

	/**
	 * Gets the internal autoincrement identifier
	 * 
	 * @return id (long)
	 */
	public long getId() {
		return id;
	}

	/**
	 * Gets the time and date of the arrival to destination
	 * 
	 * @return arrivalDate (LocalDateTime)
	 */
	public LocalDateTime getArrivalDate() {
		return arrivalDate;
	}

	/**
	 * Gets the time and date of the departures
	 * 
	 * @return departureDate (LocalDateTime)
	 */
	public LocalDateTime getDepartureDate() {
		return departureDate;
	}

	/**
	 * Gets the Booking
	 * 
	 * @return booking (Booking)
	 */
	public Booking getBooking() {
		return booking;
	}

	/**
	 * Gets the room
	 * 
	 * @return room (Room)
	 */
	public Room getRoom() {
		return room;
	}

	/**
	 * toString method
	 */
	@Override
	public String toString() {
		return "Handle [arrivalDate=" + arrivalDate + ", booking=" + booking + ", departureDate=" + departureDate
				+ ", id=" + id + ", room=" + room + "]";
	}

}
