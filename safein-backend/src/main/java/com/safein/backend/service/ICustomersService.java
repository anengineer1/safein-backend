package com.safein.backend.service;

import java.util.List;

import com.safein.backend.dto.Customers;

public interface ICustomersService {

	Customers customersById(Long id);

	Customers saveCustomer(Customers customers);

	Customers updateCustomer(Customers customers);

	List<Customers> listCustomers();

	List<Customers> listCustomersByDocNum(Long num);

	List<Customers> listCustomersByEmail(String mail);

	List<Customers> listCustomersByMedia(String media);

	Customers listByNumAndDoctype(String num, String doctype);
}
