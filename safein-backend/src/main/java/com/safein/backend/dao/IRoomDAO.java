/**
 * 
 */
package com.safein.backend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

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
	 List<Room> findRoomsByNumPersons(Long num_people); 
	
	/**Get: List all rooms By {internet_type} String */
	List<Room> findRoomsByInternet(String internet_type); 
	
	/**Get: List all rooms By {is_smoker} Boolean */
	List<Room> findRoomsBySmoker(Boolean is_smoker); 
	
	/**Get: List all rooms By has_terrace{has_terrace}Boolean */
	List<Room> findRoomsByTerrace(Boolean has_terrace); 
	
	/**TODO:Get: List all rooms in hotel By hotel_id{hotel_id} and num:people{num_people}Long Long */
	
	List<Room> findByHotelIdAndNumPersons(Long hotel_id,Long num_people);
	
}
