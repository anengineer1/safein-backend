package com.safein.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.safein.backend.dao.ICustomersDAO;
import com.safein.backend.dto.Customers;

public class CustomersServiceImpl implements ICustomersService {

	@Autowired
	ICustomersDAO iCustomersDAO;

	@Override
	public List<Customers> listCustomers() {

		return iCustomersDAO.findAll();
	}

	@Override
	public Customers saveCustomer(Customers customers) {

		return iCustomersDAO.save(customers);
	}

	@Override
	public Customers updateCustomer(Customers customers) {

		return iCustomersDAO.save(customers);
	}

	public void deleteCostumerById(Long id) {

		iCustomersDAO.deleteById(id);
	}

	@Override
	public List<Customers> listCustomersByDocNum(Long num) {

		return iCustomersDAO.findCustomersByNum(num);
	}

	@Override
	public Customers customersById(Long id) {

		return iCustomersDAO.findById(id).get();
	}

	@Override
	public List<Customers> listCustomersByEmail(String mail) {

		return iCustomersDAO.findByEmail(mail);
	}

	@Override
	public List<Customers> listCustomersByMedia(String media) {

		return iCustomersDAO.findCustomersByMedia(media);
	}

	@Override
	public Customers listByNumAndDoctype(Long num, String doctype) {

		return iCustomersDAO.findByNumAndDoctype(num, doctype);
	}

}
