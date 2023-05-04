package com.safein.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safein.backend.dto.Hotel;


public interface IHotelsDAO extends JpaRepository<Hotel, Long>{

}
