package com.safein.backend.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safein.backend.dto.Hotel;


public interface IHotelsDAO extends JpaRepository<Hotel, Long>{

	List<Hotel> findHotelsByCityId(int idcity);

	List<Hotel> findHotelsBySecurityLevel(String securityLevel);
	
	List<Hotel> findByEnergySuficient(boolean energy_suficient);
	


}
