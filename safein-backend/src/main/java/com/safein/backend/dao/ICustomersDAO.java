package com.safein.backend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safein.backend.dto.Customers;



public interface ICustomersDAO extends JpaRepository<Customers, Integer>{

	List<Customers> findByEmail(String mail);

	List<Customers> findCostumersByNum(int num);

	List<Customers> findCostumersByMedia(String media);
	
	Customers findByNumAndDoctype(int num, String doctype);

}
