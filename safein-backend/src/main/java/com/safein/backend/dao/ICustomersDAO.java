package com.safein.backend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safein.backend.dto.Customers;

public interface ICustomersDAO extends JpaRepository<Customers, Long> {

	List<Customers> findByEmail(String mail);

	List<Customers> findCustomersByName(Long num);

	List<Customers> findCustomersByPressMedia(String media);

	Customers findByNumIdentifierAndDocIdentifier(Long num, String doctype);

}
