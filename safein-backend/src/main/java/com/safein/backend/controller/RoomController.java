/**
 * 
 */
package com.safein.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safein.backend.dto.Room;
import com.safein.backend.service.RoomServiceImpl;

/**
 * @author Elena, Alejandro, Francisco
 *
 */
@RestController
@RequestMapping("/")
public class RoomController {

	@Autowired
	RoomServiceImpl iRoomServiceImpl;

	/** Get: List all rooms */
	@GetMapping("/rooms")
	public List<Room> listRooms() {
		return iRoomServiceImpl.listRooms();
	}

	/** Get: Rooms By id */
	@GetMapping("/rooms/{id}")
	public Room getRoomById(@PathVariable(name = "id") Long id) {
		return iRoomServiceImpl.getRoomById(id);
	}

	/** Get: List all rooms by Hotel ID */
	@GetMapping("/rooms/hotels/{id}") 
	public List<Room> listRoomsByHotelId(@PathVariable(name = "hotel_id")Long hotel_id) {
		return iRoomServiceImpl.listRoomsByHotelId(hotel_id);
	}

	/** Get: List all rooms By {num_people} String */
	@GetMapping("/rooms/numpeople/{num_people}")
	public List<Room> listRoomsByNumPersons(@PathVariable(name = "num_people") Long num_people) {
		return iRoomServiceImpl.listRoomsByNumPersons(num_people);
	}

	/** Get: List all rooms By {internet_type} String */
	@GetMapping("/rooms/inettype/{internet_type}")
	public List<Room> listRoomsByInternet(@PathVariable(name = "internet_type")String internet_type) {
		return iRoomServiceImpl.listRoomsByInternet(internet_type);
	}

	/** Get: List all rooms By {is_smoker} Boolean */
	@GetMapping("/rooms/smoke/{is_smoker}")
	public List<Room> listRoomsBySmoker(@PathVariable(name = "is_smoker") Boolean is_smoker) {
		return iRoomServiceImpl.listRoomsBySmoker(is_smoker);
	}

	/** Get: List all rooms By has_terrace{has_terrace}Boolean */
	@GetMapping("/rooms/terrace/{has_terrace}")
	public List<Room> listRoomsByTerrace(@PathVariable(name = "has_terrace")Boolean has_terrace) {
		return iRoomServiceImpl.listRoomsByTerrace(has_terrace);
	}

	/**
	 * TODO:Get: List all rooms in hotel By hotel_id{hotel_id} and
	 * num:people{num_people}Long Long
	 */
	@GetMapping("/rooms/{hotel_id}/numpers/{num_people}")
	public List<Room> listRoomsByHotelIdAndNumPeople(@PathVariable(name = "is_smoker")Long hotel_id, @PathVariable(name = "num_people")Long num_people){
		return iRoomServiceImpl.listByHotelIdAndNumPersons(hotel_id, num_people);
	}

}