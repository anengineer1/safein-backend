/**
 * 
 */
package com.safein.backend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.safein.backend.dto.Booking;
import com.safein.backend.dto.Handle;
import com.safein.backend.dto.Room;


/**
 * @author Elena, Alejandro, Francisco
 *
 */
public interface IRoomDAO  extends JpaRepository<Room, Long>{
	
	/**Get: List all rooms by Hotel ID */
	 List<Room> findRoomsByHotelId(Long hotel_id); 
	
	/**TODO:Get: List all rooms from hotel By {hotel_id} and {code}Long Long */
	
	/**Get: List all rooms By {num_people} String */
	 List<Room> findRoomsByNumPeople(Long numPeople); 
	
	/**Get: List all rooms By {internet_type} String */
	List<Room> findRoomsByInternetType(String internet_type); 
	
	/**Get: List all rooms By {is_smoker} Boolean */
	List<Room> findRoomsByIsSmoker(Boolean is_smoker); 
	
	/**Get: List all rooms By has_terrace{has_terrace}Boolean */
	List<Room> findRoomsByHasTerrace(Boolean has_terrace); 
	
	/**TODO:Get: List all rooms in hotel By hotel_id{hotel_id} and num:people{num_people}Long Long */
	List<Room> findByNumPeopleAndHotelId(Long numPeople, Long hotelId);

	List<Room> findByHandles(Handle handle);
	
}
