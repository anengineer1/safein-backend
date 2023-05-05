package com.safein.backend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safein.backend.dto.Customers;

public interface ICustomersDAO extends JpaRepository<Customers, Long> {

	List<Customers> findByEmail(String mail);

	List<Customers> findCustomersByNum(Long num);

	List<Customers> findCustomersByMedia(String media);

	Customers findByNumAndDoctype(Long num, String doctype);

}
