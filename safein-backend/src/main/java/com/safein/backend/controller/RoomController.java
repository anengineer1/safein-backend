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

import com.ex02.c4.dto.Appoinment;
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
	public List<Room> listRooms(){
		return iRoomServiceImpl.listRooms();
	}
	/** Get: Rooms By id */
	@GetMapping("/rooms/{id}")
	public Room getRoomById(Long id){
		return iRoomServiceImpl.getRoomById(id);
	}
	
	/** Get: List all rooms by Hotel ID */
	/* @GetMapping("/rooms/hotels/{id}") */
	

	
	/** TODO:Get: List all rooms from hotel By {hotel_id} and {code}Long Long */
	/* @GetMapping("/rooms/hotels/{hotel_id}/code") */
	
	
	/** Get: List all rooms By {num_people} String */
	
	/** Get: List all rooms By {internet_type} String */
	
	/** Get: List all rooms By {is_smoker} Boolean */
	
	/** Get: List all rooms By has_terrace{has_terrace}Boolean */
	
	/**
	 * TODO:Get: List all rooms in hotel By hotel_id{hotel_id} and
	 * num:people{num_people}Long Long
	 */
}
