/**
 * 
 */
package com.safein.backend.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safein.backend.dao.IRoomDAO;
import com.safein.backend.dto.Room;

/**
 * @author Elena, Alejandro, Francisco
 *
 */
@Service
public class RoomServiceImpl implements IRoomService {

	@Autowired
	IRoomDAO iRoomDAO;

	/** Get: List all rooms */
	@Override
	public List<Room> listRooms() {
		return iRoomDAO.findAll();
	}

	/** Get: Rooms By id */
	@Override
	public Room getRoomById(Long id) {
		return iRoomDAO.findById(id).get();
	}

	/** Get: List all rooms by Hotel ID */
	@Override
	public List<Room> listRoomsByHotelId(Long hotel_id) {
		return iRoomDAO.findRoomsByHotelId(hotel_id);
	}

	/** TODO:Get: List all rooms from hotel By {hotel_id} and {code}Long Long */

	/** Get: List all rooms By {num_people} String */
	@Override
	public List<Room> listRoomsByNumPersons(Long numPeople) {
		return iRoomDAO.findRoomsByNumPeople(numPeople);
	}

	/** Get: List all rooms By {internet_type} String */
	@Override
	public List<Room> listRoomsByInternet(String internet_type) {
		return iRoomDAO.findRoomsByInternetType(internet_type);
	}

	/** Get: List all rooms By {is_smoker} Boolean */
	@Override
	public List<Room> listRoomsBySmoker(Boolean is_smoker) {
		return iRoomDAO.findRoomsByIsSmoker(is_smoker);
	}

	/** Get: List all rooms By has_terrace{has_terrace}Boolean */
	@Override
	public List<Room> listRoomsByTerrace(Boolean has_terrace) {
		return iRoomDAO.findRoomsByHasTerrace(has_terrace);
	}

	/**
	 * TODO:Get: List all rooms in hotel By hotel_id{hotel_id} and
	 * num:people{num_people}Long Long
	 */

	@Override
	public List<Room> listByHotelIdAndNumPersons(Long hotel_id, Long numPeople) {
		List<Room> rooms_by_hotel = listRoomsByHotelId(hotel_id);
		List<Room> hs = new ArrayList<>();

		for (Room room : rooms_by_hotel) {
			hs.addAll(iRoomDAO.findRoomsByNumPeople(numPeople));
		}
		
		return hs;
	}

	/* Create a room*/
	@Override
	public Room saveRoom(Room room) {
		return iRoomDAO.save(room);
	}

	public Room updateRoom(Room room) {
		
		return iRoomDAO.save(room);
	}
}
