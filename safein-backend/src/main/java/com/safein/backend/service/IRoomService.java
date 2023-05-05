/**
 * 
 */
package com.safein.backend.service;

import java.util.List;

import com.safein.backend.dto.Room;

/**
 * @author Elena, Alejandro, Francisco
 *
 */
public interface IRoomService {

	/** Get: List all rooms */
	public List<Room> listRooms();

	/** Get: Room By id*/
	public Room getRoomById(Long id);
	
	/** Get: List all rooms by Hotel ID */
	public List<Room> listRoomsByHotelId(Long hotel_id);

	/** Get: List all rooms By {num_people} String */
	public List<Room> listRoomsByNumPersons(Long num_people);

	/** Get: List all rooms By {internet_type} String (come from enum)*/
	public List<Room> listRoomsByInternet(String internet_type);

	/** Get: List all rooms By {is_smoker} Boolean */
	public List<Room> listRoomsBySmoker(Boolean is_smoker);

	/** Get: List all rooms By has_terrace{has_terrace}Boolean */
	public List<Room> listRoomsByTerrace(Boolean has_terrace);

	/**
	 * TODO:Get: List all rooms in hotel By hotel_id{hotel_id} and
	 * num:people{num_people}Long Long
	 */
	public List<Room> listByHotelIdAndNumPersons(Long hotel_id,Long num_people);
}
